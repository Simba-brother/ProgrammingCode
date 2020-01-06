import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Digital_triangle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read();  //这个三角形有n行
        int[][] matrix = new int[n+1][n+1];
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                matrix[row][col] = br.read();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j=1; j<=n; j++) {
                matrix[i][j] = Math.max(matrix[i-1][j-1], matrix[i-1][j]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, matrix[n][i]);
        }
        System.out.println(res);
    }
}