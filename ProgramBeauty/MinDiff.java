import java.util.Arrays;

public class MinDiff {
    public static void main(String[] args) {
        int[] data = {1,4,6,7,8,32};
        method_1(data);
        method_2(data);
    }
    

    private static int method_2(int[] data) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(data);
        for (int i = 1; i < data.length; i++) {
            min = Math.min(min, data[i]-data[i-1]);
        }
        return min;
    }

    private static int method_1(int[] data) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            for (int j = i+1; j < data.length; j++) {
                if (min > data[j]- data[i]) {
                    min = data[j]-data[i];
                }
            }
        }
        return min;
    }
}