import java.util.Scanner;

public class HannoTa {
    public static void main(String[] args) {
        System.out.println("请输入汉诺塔的盘子数目：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getAnswer(n, 'X', 'Y', 'Z');
        sc.close();
    }
    /**
     * x针上的n个盘子借助y针移动到z针上
     * @param n  盘子个数
     * @param x  x针
     * @param y  y针
     * @param z  z针
     */
    private static void getAnswer(int n, char x, char y, char z) {
        if (n==1) {
            System.out.println(x+"-->"+z);
        }else {
            getAnswer(n-1, x, z, y);
            System.out.println(x+"-->"+z);
            getAnswer(n-1, y, x, z);
        }
    }
}