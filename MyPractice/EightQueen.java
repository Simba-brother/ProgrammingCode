public class EightQueen {
    public static void main(String[] args) {
        int[][] chess = new int[8][8];  // 棋盘
        getAnswer(chess, 0);
    }

    private static void getAnswer(int[][] chess, int row) {
        //把当前棋盘的格局进行拷贝
        int[][] tempChess = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tempChess[i][j] = chess[i][j];
            }
        }
        if (row == 8) {     //递归参数出口
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(tempChess[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }else {
            for (int j = 0; j < 8; j++) {   //尝试该行的列
                //System.out.println(noDanger(tempChess, row, j));
                if (noDanger(tempChess, row, j)) {
                    for (int k = 0; k < 8; k++) {
                        tempChess[row][k] = 0;
                    }
                    tempChess[row][j] = 1; //更新棋盘格局，尝试成功,准备递归
                    getAnswer(tempChess, row+1);  //把当前棋盘格局传入，递归当前棋盘下一行
                    //break;
                }
            }
            
        }
    }

    private static boolean noDanger(int[][] tempChess, int row, int j) {
        boolean shu = true;
        boolean hen = true;
        boolean zuoShang = true;
        boolean zuoXia = true;
        boolean youShang = true;
        boolean youXia = true;

        //判断j列是否合法
        for (int i = 0; i < 8; i++) {
            if (tempChess[i][j] == 1) {
                shu = false;
                break;
            }
        }
        //判断row行是否合法
        for (int k = 0; k < 8; k++) {
            if (tempChess[row][k] == 1) {
                hen = false;
                break;
            }
        }
        //判断左上方是否合法
        for (int i = row,  k = j; i >= 0 && k>=0; i--, k--) {
            if (tempChess[i][k] == 1) {
                zuoShang = false;
                break;
            }
        }
        //判断右下方是否合法
        for (int i = row, k = j; i<8 && k<8; i++, k++) {
            if (tempChess[i][k] == 1) {
                youXia = false;
                break;
            }
        }
        //判断左下方是否合法
        for (int i = row, k = j; i < 8&&k>=0; i++, k--) {
            if (tempChess[i][k] == 1) {
                zuoXia = false;
                break;
            }
        }
        //判断右上方是否合法
        for (int i = row, k = j; i>=0 && k<8; i--, k++) {
            if (tempChess[i][k] == 1) {
                youShang = false;
                break;
            }
        }

        
        return shu && hen && zuoShang && zuoXia && youShang && youXia;
    }
}