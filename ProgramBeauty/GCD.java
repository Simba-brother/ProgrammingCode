import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        gcd_method(x, y);
    }

    private static int gcd_method(int x, int y) {
        if (y> x) {
            return gcd_method(y, x);
        }else {
            return (y==0)?x:gcd_method(y,x%y);
        }
        
    }
}