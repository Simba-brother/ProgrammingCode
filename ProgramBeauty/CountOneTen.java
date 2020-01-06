import java.util.Scanner;

public class CountOneTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            count += help(i);
        }
        System.out.println(count);
        sc.close();
    }

    public static int help(int v) {
        int res = 0;
        while (v!=0) {
            res += v%10==1?1:0;
            v /= 10;            
        }
        return res;
    }
}