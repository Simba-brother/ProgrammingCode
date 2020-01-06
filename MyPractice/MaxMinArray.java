import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * MaxMinArray
 */
public class MaxMinArray {

    public static void main(String[] args) throws IOException{
        // int[] arr = {1, 2, 3, 4, 5};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 =  br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int num = Integer.parseInt(line1[1]);
        int[] arr = new int[n];
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }
        // int num = 2;
        int res = getAnswer(arr, num);
        System.out.println(res);
    }

    private static int getAnswer(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i<arr.length) {
            while (j<arr.length) {
                while (!qmax.isEmpty() && arr[qmax.peekLast()]<= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if (arr[qmax.peekFirst()]-arr[qmin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += (j-1)-i+1;
            i++;
        }
        return res;
    }
}