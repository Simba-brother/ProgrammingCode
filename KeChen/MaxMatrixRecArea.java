import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * MaxMatrixRecArea
 */
public class MaxMatrixRecArea {

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
        int res = getAnswer(matrix);
        System.out.println(res);
        // int[][] matrix = {
        //     {1, 0, 1, 1},
        //     {1, 1, 1, 1},
        //     {1, 1, 1, 0}
        // };
        
        //int[] heigh = {3, 4, 5, 4, 3, 6};  //柱状图
        //int res = getAreaZhu(heigh);
        //System.out.println(res);
    }   



    private static int getAnswer(int[][] matrix) {
        //参数合法判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //输入已合法。
        int[] heigh = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heigh[j] = matrix[i][j] == 0 ? 0 : heigh[j]+1;
            }
            //第i行的heigh数组就有了
            res = Math.max(res, getAreaZhu(heigh));
        }
        return res;
    }

    private static int getAreaZhu(int[] heigh) {
        if (heigh == null || heigh.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heigh.length; i++) {
            while (!stack.isEmpty() && heigh[stack.peek()] >= heigh[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, ((i-1)-(k+1)+1)*heigh[j]);
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, ((heigh.length-1)-(k+1)+1)*heigh[j]);
        }
        return maxArea;
    }
}