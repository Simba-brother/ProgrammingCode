import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * MaxWindowArray
 */
public class MaxWindowArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int w = Integer.parseInt(line1[1]);
        String[] line2 = br.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(line2[i]);
        }
        int[] res = getAnswer(array, w);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static int[] getAnswer(int[] array, int w) {
        if (array == null || array.length < w || w < 1) {
            return null;
        }
        int n = array.length;
        int[] res = new int[n-w+1];
        int index = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!qmax.isEmpty() && array[qmax.peekLast()]<=array[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i-w) {
                qmax.pollFirst();
            }
            if (i >= w-1) {
                res[index++] = array[qmax.peekFirst()];
            }
        }
        return res;
    }
}