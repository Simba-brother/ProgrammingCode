import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * MaxSubMatrix
 */
public class MaxSubMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] datas = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(datas[j]);
            }
        }
        int res = maxRecSize(matrix);
        System.out.println(res);
    }

    private static int maxRecSize(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == 0 ? 0 : height[j]+1;
            }
            maxArea = Math.max(maxArea, maxRecFromBottom(height));
        }
        return maxArea;
    }

    private static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;           
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int j = stack.pop();
                int k = stack.isEmpty()?-1:stack.peek();
                int curArea = ((i-1)-(k+1)+1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty()?-1:stack.peek();
            int curArea = ((height.length-1)-(k+1)+1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}