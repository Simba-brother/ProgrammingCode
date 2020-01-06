import java.util.Arrays;

public class MaxMultiSubArray {
    public static void main(String[] args) {
        int[] data = new int[10];
        int[] s = new int[data.length];
        int[] t = new int[data.length];
        int[] p = new int[data.length];
        method(data, s, t, p);        
    }

    private static int method(int[] data, int[] s, int[] t, int[] p) {
        s[0] = 1;
        for (int i = 1; i < data.length; i++) {
            s[i] = data[i-1]*s[i-1];
        }
        t[data.length-1] = 1;
        for (int j = data.length-2; j >= 0; j++) {
             t[j] = t[j+1]*data[j+1];
        }
        for (int k = 0; k < data.length; k++) {
            p[k] = t[k]*s[k];
        }
        Arrays.sort(p);
        return p[p.length-1];
    }
}