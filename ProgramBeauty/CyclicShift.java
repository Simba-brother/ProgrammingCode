public class CyclicShift {
    public static void main(String[] args) {
        int[] data = new int[10];
        int k = 5;
        method_1(data, k);
        method_2(data, k);
        method_3(data, k);
    }

    private static void method_3(int[] data, int k) {
        int n= data.length;
        k %= n;
        reverse(data, 0, n-k-1);
        reverse(data, n-k, n-1);
        reverse(data, 0, n-1);
    }

    private static void reverse(int[] data, int b, int e) {
        for ( ; b < e; b++,e--) {
            int temp = data[e];
            data[e] = data[b];
            data[b] = temp;
        }
    }

    private static void method_2(int[] data, int k) {
        int n = data.length;
        k %= n;
        while (k-- != 0) {
            int temp =data[n-1];
            for (int i = n-1; i > 0; i--) {
                data[i] = data[i-1];
            }
            data[0] =temp;
        }
    }

    private static void method_1(int[] data, int k) {
        int n = data.length;
        while (k-- != 0) {   //[k, 1] 循环k次
            int temp = data[n-1];
            for (int i = n-1; i >0; i--) {
                data[i] = data[i-1];
            }
            data[0] = temp;
        }
    }
}