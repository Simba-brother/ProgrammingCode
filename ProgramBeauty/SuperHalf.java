import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperHalf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] data = new int[split.length];
        method_1(data);
    }

    public static int method_1(int[] data) {
        int times = 0;
        int cur = 0;
        for (int i = 0; i < data.length; i++) {
            if (times == 0) {
                cur = data[i];
                times = 1;
            }else {
                if (data[i] == cur) {
                    times++;
                }else {
                    times--;
                }
            }
        }
        return cur;
    }
}