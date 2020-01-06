/**
 * ReverseInteger
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = -123;
        int answer = reverse(x);
        System.out.println(answer);
    }

    private static int reverse(int x) {
        int rev = 0;
        while (x !=0 ) {
            int new_rev = rev*10 + x%10;
            if ((new_rev - x%10)/10 != rev) {
                return 0;
            }
            rev = new_rev;
            x /= 10;
        }
        return rev;
    }
}