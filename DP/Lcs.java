import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lcs {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read();  //两个串的长度都为n
        int[][] dp = new int[n+1][n+1];
        int[] A = new int[n+1]; // 不用A[0] 为了和dp下标保持一致
        int[] B = new int[n+1];
        String[] split_a = br.readLine().split(" ");
        String[] split_b = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(split_a[i]);
            B[i] = Integer.parseInt(split_b[i]);
        }
        System.out.println(getLcs(A, B, dp));  

    }

    private static int getLcs(int[] a, int[] b, int[][] dp) {
        int n = dp.length-1;
        for (int row = 1; row <=n ; row++) {
            for (int col = 1; col <=n; col++) {
                if (a[row] == b[col]) {
                    dp[row][col] = dp[row-1][col-1]+1;
                }else {
                    dp[row][col] = Math.max(dp[row][col-1], dp[row-1][col]);
                }
            }
        }
        return dp[n][n];
    }
}