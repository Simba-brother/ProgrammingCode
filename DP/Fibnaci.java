public class Fibnaci {
    private static int[] M;
    public static void main(String[] args) {
        M = new int[6];
        M[0] = 0;
        M[1] = 1;
        for (int i = 2; i < M.length; i++) {
            M[i] = Integer.MAX_VALUE;
        }
        int ans = fib(5); // 0, 1, 1, 2, 3, 5

        System.out.println(ans);
    }

    private static int fib(int n) {
        if (n<2){
            return n;
        }
        if (M[n] == Integer.MAX_VALUE) {
            M[n]= fib(n-1) + fib(n-2);
        }
        return M[n];
    }
}