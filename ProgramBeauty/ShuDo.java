import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuDo {
    /**
     * 坐标类，定位cells中的当前哪个cell
     */
    static class Location {
        int x;
        int y;

        /**
         * @param x 横坐标
         * @param y 纵坐标
         */

        public Location() {
            this.x = -1;
            this.y = -1;
        }

        /**
         * @return the x
         */
        public int getX() {
            return x;
        }

        /**
         * @param x the x to set
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * @return the y
         */
        public int getY() {
            return y;
        }

        /**
         * @param y the y to set
         */
        public void setY(int y) {
            this.y = y;
        }

        
    }
    /**
     * Cell[][] cells中的item, 每一个cell有一下属性
     *  （1）是否被处理过
     *  （2）该cell的有效值列表
     *  （3）该cell的值
     *  （4）该cell被回溯第几次了，初始值为0
    */
    static class Cell {
        public boolean isProcessed; // 这个格子是否被处理过 
        public List<Integer> validList;  //这个格子中可以放入的有效数字的列表
        public int value;   //这个格子中的值
        public int pro_num; //这个格子被回溯了几次

        Cell() {
            isProcessed = false;
            validList = null;
            value = -1;
            pro_num =0;
        }
        /**
         * 给这个cell随街注入一个有效值
         */
        // public void piceValidValue() {
        //     Random random = new Random();
        //     int resIndex = random.nextInt(validList.size());  //随机获得有效列表的一个下标
        //     this.value = validList.get(resIndex);
        // }

        /**
         * 给这个cell的属性清空（值， 有效列表， 处理标志）
         */
        // public void clear() {
        //     this.isProcessed = false;
        //     this.validList = null;
        //     this.val = -1;
        // }

        /**
         * @return the isProcessed
         */
        public boolean getIsProcessed() {
            return isProcessed;
        }

        /**
         * @param isProcessed the isProcessed to set
         */
        public void setProcessed(boolean isProcessed) {
            this.isProcessed = isProcessed;
        }

        /**
         * @return the validList
         */
        public List<Integer> getValidList() {
            return validList;
        }

        /**
         * @param validList the validList to set
         */
        public void setValidList(List<Integer> validList) {
            this.validList = validList;
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * @return the pro_num
         */
        public int getPro_num() {
            return pro_num;
        }

        /**
         * @param pro_num the pro_num to set
         */
        public void setPro_num(int pro_num) {
            this.pro_num = pro_num;
        }

        

    }
    public static void main(String[] args) {
        Location cur_loc = new Location();    //申明一个当前位置对象  cur_loc
        cur_loc.setX(0);
        cur_loc.setY(0);
        int metrixSize = 9;     // 9*9的一个数独矩阵
        Random random = new Random();
        Cell[][] cells = new Cell[9][9]; // 9*9的一个数独矩阵
        //给细胞矩阵都初始默认属性的值
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new Cell();
            }
        }
        /**
         * 开始构建数独
         */
        while (true) {
            //看一下现在即将要处理的位置
            System.out.println("x="+cur_loc.getX()+"y="+cur_loc.getY());
            //获得该位置下的cell对象
            Cell c = cells[cur_loc.getX()][cur_loc.getY()];
            //看一下该位置下的cell是否被处理过
            System.out.println("c.getIsProcessed()"+c.getIsProcessed());
            //用于接收返回的有效值列表
            List al;
            /**
             * 分为两种情况：1:cell没有被处理过，2cell被处理过
             *      没有处理过的话， 说明该cell 没有被注入有效值list,进行注入
             *      处理过了的话，说明现在是回溯到了cell，需要更新cell的pro_count回溯次数属性
             *          if 回溯次数 > 有效值列表 进行回溯。
             */
            if (!c.getIsProcessed()) {  //如果这个cell没有没处理过，需要给这个c注入可行list
                al = getValidValueList(cur_loc, cells);     //获得当前位置的所有可行val
                c.setValidList(al); //给当前cell注入所有可行值--list
                System.out.println("list:"+c.getValidList());
            }else { //如果这个cell处理过，说明该cell.validList是被注入过的,回溯次数需要+1
                int pro_count = c.getPro_num()+1; // 回溯次数需要++；
                System.out.println("回溯次数--："+pro_count);
                System.out.println(c.getValidList());   // 打印cell的有效列表
                c.setPro_num(pro_count);    //更新cell的回溯次数

                if (c.getPro_num() == c.getValidList().size()) {   // 如果c的回溯次数 == cell的有效列表
                    // 初始化c
                    c.setPro_num(0);
                    c.setProcessed(false); 
                    c.setValidList(null);
                    c.setValue(-1);

                    cur_loc = preLocal(cur_loc);
                    System.out.println("我要回溯到x="+cur_loc.getX()+"y="+cur_loc.getY());
                    continue;
                }
            }
            //如果该cell有有效值
            if (c.getValidList() != null) {
                if (c.getValidList().size() > 1) {
                    int valIndex = random.nextInt(c.getValidList().size());
                    c.setValue(c.getValidList().get(valIndex)); //给c随机注入一个有效值
                }else {
                    c.setValue(c.getValidList().get(0));
                }
                c.setProcessed(true);
                if (cur_loc.getX() == metrixSize-1 && cur_loc.getY() == metrixSize-1) {
                    break;
                }else {
                    cur_loc = nextLocal(cur_loc);
                }
            }else { //如果该cell没有一个有效的值 说明前面填错了需要回溯
                //回溯第一步：判断
                if (cur_loc.getX() == 0 && cur_loc.getY() == 0) {
                    break;
                }
                //回溯第二步：初始化现在
                c.setPro_num(0);
                c.setProcessed(false);
                c.setValidList(null);
                c.setValue(-1);
                cur_loc = preLocal(cur_loc);
                System.out.println("我要回溯到x="+cur_loc.getX()+"y="+cur_loc.getY());
            }

            //最后打印一下我们填好的数独
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (col != 8) {
                        System.out.print(cells[row][col].getValue()+" ");
                    }else {
                        System.out.println(cells[row][col].getValue());
                    }
                }
            }
        }
    }

    public static Location nextLocal(Location cur_loc) {
        int x = cur_loc.getX();
        int y = cur_loc.getY();
        if (y != 8) {
            y++;
        }else {
            y = 0;
            x++;
        }
        cur_loc.setX(x);
        cur_loc.setY(y);
        return cur_loc;
    }

    public static Location preLocal(Location cur_loc) {
        int x = cur_loc.getX();
        int y = cur_loc.getY();

        if (y != 0) {
            y--;
        }else {
            x--;
            y=8;
        }
        cur_loc.setX(x);
        cur_loc.setY(y);
        return cur_loc;
    }

    /**
     * 
     * @param cur_loc   //当前位置
     * @param cells     //cells矩阵
     * @return
     */
    private static List getValidValueList(Location cur_loc, Cell[][] cells) {
        int x = cur_loc.getX();     //定位到了哪个cell
        int y = cur_loc.getY();
        List<Integer> list= new ArrayList<>();  //准备存放所有有效值
        for (int k = 1; k < 10; k++) {
            boolean flag_x = true;  //标记这一行是否与num值是否冲突
            boolean flag_y = true;  //标记当这个cell放k时,列是否合理
            boolean flag =  true;   //标记当这个cell放k时，小矩阵是否合理
            int num = k;    // 尝试给这个location放num;
            //看看这一行是否有相同的值
            for (int col = 0; col < 9; col++) {
                if (col != y && cells[x][col].getValue() == num){    //这一行除了本身有相同的值
                    flag_x = false; //  行标记设为false
                }
            }
            //看看同一列是否有相同的值
            for (int row = 0; row < 9; row++) {
                if (row != x && cells[row][y].getValue() == num) {
                    flag_y = false;
                }
            }
            //看一看同一个3*3的小矩阵中是否有效
            int n=0;    //这个小矩阵的行开始索引
            int m=0;    //这个小矩阵的列开始索引
            if (x % 3 == 0) {
                n = x;    
            }
            if (x %3 == 1) {
                n = x-1;               
            }

            if (x%3 == 2 ) {
                n = x -2;
            }

            if (y %3 == 0) {
                m = y;
            }
            if (y %3 == 1) {
                m = y-1;
            }
            if (y %3 == 2) {
                m = y-2;
            }
            //此时当前cell的所处的小矩阵已经定为好了
            for (int small_row = n; small_row < n+3; small_row++) {
                for (int small_col = m; small_col < m+3; small_col++) {
                    if (cells[small_row][small_col].getValue() == num) {
                        flag = false;
                    }
                }
            }
            if (flag_x == true && flag_y == true && flag ==  true ) {
                list.add(num);
            }
        }
        if (list.size() > 0) {
            return list;
        }else {
            return null;
        }
    }
}