import java.util.Scanner;

public class Main {
    static int[] stones = {0, 0, 0, 0, 0, 0, 0, 0}; //0代表石头还在
    static int N = stones.length;   //石头数量
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        play(stones, N);
    }

    /**
     * 对手只能取start 向右边取
     * @param stones    石头数组    
     * @param start     要拿的石头索引
     * @param number    要拿几个石头
     * @return  对手是否取石头成功
     */
    public static boolean take_stone(int[] stones, int start, int number) {
        boolean isSuccess = true;  //用于返回对手取石头是否成功
        if (start < 0 || start >= len || start + number > len || number < 1 || number > 2) {
           return false;
        }
        if ((number == 1) && (stones[start] != 0) || (number == 2) && (stones[start] != 0 || stones[start+1] != 0)) {
            return false;
        }
        if (number  == 1) {
            stones[start] = 1;
        }else{
            stones[start] =1;
            stones[start+1] = 1;
        }
        return isSuccess;
    }

    public static void play(int[] stones, int N) {
        int start = 0; // 对手准备拿哪个石头开始
        int number = 0; // 对手准备拿几个石头
        int rount = 0; //第几个回合， 从第0个回合开始
        while (scan(stones, start, number, round)) {    //第0回合我先去取中间两个
            //游戏还未结束，接收用户输入
            print(stones);
            start = sc.nextInt();   //对手准备拿的石头索引
            number = sc.nextInt();  //对手准备拿的石头个数
            while (!take_stone(stones, start, number)) {  //只要你拿不成功
                System.out.println("你的输入不符合规则，请重新输入：");
                start = sc.nextInt();   //对手准备拿的石头索引
                number = sc.nextInt();  //对手准备拿的石头个数
            }
            //对手已经拿走石头了, 回合数++
            rount++;
        }
    }

    public static void print(int[] stones) {
        for (int i = 0; i < N; i++) {
            System.out.print(stones[i] + " ");
        }
        System.out.println();
    }

    /**
     * 
     * @param stones    石头数组
     * @param start     对手选择从几号石头开始拿
     * @param number    对手选择拿几个石头 1或者2   
     * @param round     现在是第几回合
     */
    public static boolean scan(int[] stones, int start, int number, int round) {
        boolean isHaveStone = false;
        int mid = 0;
        if (round == 0) {   //如果是第0回合， start和number一定等于0
            mid  = (len -1) / 2;
            stones[mid] = 1;    // 表示把mid给取了、
            if (len %2 == 0) {
                stone[mid + 1] = 1;
            }
        }else {
            mid = len -1 -start;
            stone[mid] = 1;
            mid = mid - (number-1);  //根据对手的拿石头数量决定是否拿取mid左边一个石头
            stone[mid] = 1;
        }
        //我拿取石头后需要遍历石头看游戏是否结束
        for (int i = 0; i < N; i++) {
            if (stone[i] == 0) {
                isHaveStone = true;
                break;
            }
        }
        return isHaveStone;
    }
}