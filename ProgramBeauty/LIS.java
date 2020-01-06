import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] data = new int[10];
        method_1(data);
    }

    private static int method_1(int[] data) {
        int[] LIS = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j] && LIS[j]+1>LIS[i]) {
                    LIS[i] = LIS[j]+1;
                }
            }
        }
        Arrays.sort(LIS);
        return LIS[LIS.length-1];
    }
}