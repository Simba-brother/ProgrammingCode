import java.util.Scanner;

public class CountOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();   //待测x的二进制表示有几个1
        method_1(x);
        method_2(x);
        sc.close();
    }
    

    public static int method_1(int x) {
        int count = 0;
        while (x != 0) {
            count += x % 2; //x为奇数时 x%2 ==1， x为偶数时x%2 == 0
            x = x/2;    //x的二进制表示右移，左边补0
        }
        return count;
    }

    public static int method_2(int x) {
        int count = 0;
        while (x!=0) {
            count += x ^ 0x01;
            x = x >> 1;
        }
        return count;
    }
}