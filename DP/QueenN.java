import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class QueenN {
    static int count = 0;   //总共有多少种摆法
    static int SIZE = 0;    //皇后的数量
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SIZE = sc.nextInt(); // 皇后数
        LinkedList<Location> queue = new LinkedList<>();
        nQueue(queue, 0, 0);    //从第0行，第0列开始摆放皇后
        System.out.println(count);
        sc.close();
    }
    
    /**
     * 
     * @param queue 已经好的皇后们的位置坐标
     * @param x 当前准备在x行y列处摆放皇后
     * @param y 当前准备在x行y列处摆放皇后
     */
    private static void nQueue(LinkedList<Location> queue, int x, int y) {
        if (queue.size() == SIZE) { //递归出口
            count++;
            printLocal(queue);
            return;
        }
        for (int i = x; i < SIZE; i++) {    //拿到当前行
            Location loc = new Location(i, y);  //封装当前行和列
            if (isLegalLoc(queue, loc)) { //当前位置是否合法
                queue.offer(loc);   
                nQueue(queue, 0, y+1);  //是以列来递归的, 每次都要将行设置为0，因为列++了
                queue.pollLast();
            } 
        }
    }

    private static void printLocal(LinkedList<Location> queue) {
        int[][] matrix = new int[SIZE][SIZE];
        for (Location loc : queue) {
            System.out.println(loc.toString()+"\t");
            matrix[loc.x][loc.y] = 1;
        }
        System.out.println();
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    private static boolean isLegalLoc(LinkedList<Location> queue, Location loc) {
        for (Location each : queue) {
            if (each.x == loc.x || each.y == loc.y) {
                return false;
            }else if (Math.abs(each.x - loc.x) == Math.abs(each.y - loc.y) ){  //斜线
                return false;
            }
        }
        return true;
    }

    static class Location {
        int x; //行坐标
        int y; //列坐标
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

        @Override
        public String toString() {
            return "Location [x=" + x + ", y=" + y + "]";
        }
    }
}