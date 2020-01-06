import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MaxAndMin {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] a = new int[n];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }
        int[][] dp = new int[n][m];
        for (int j =0; j< m; j++) {
            dp[0][j] = a[0];    //第0行，dp[0][j]  = a[0]
        }
        for (int k =1; k<n; k++) {
            dp[k][0] = dp[k-1][0]+a[k]; // 第0列，代表只份一组，累加
        }
        for (int row = 1; row <n; row++) {
            for(int col = 1; col<m; col++) {
                int sum = 0;
                int min = Integer.MAX_VALUE;
                for (int l=row; l>0; l--) {
                    sum += a[l];
                    min = Math.min(Math.max(sum, dp[l-1][col-1]),min);
                    if(sum >= min) break;
                }
                dp[row][col] = min;
            }
        }
        System.out.println(dp[n-1][m-1]); 
        br.close();
    }
}