import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        method_1(N);
        method_2(N);
        sc.close();
    }

    public static int method_1(int N) {
        int count=0;
        for (int i = 1; i <= N; i++) {
            int temp = i;
            while (temp %5 == 0) {
                count++;
                temp /= 5;
            }
        }
        return count;
    }

    public static int method_2(int N) {
        int count = 0;
        while (N != 0) {
            N >>= 1;
            count += N;
        }
        return count;
    }
}