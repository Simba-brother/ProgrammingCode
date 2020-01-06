public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] data = new int[10];
        method_1(data);
        method_2(data);
    }

    private static void method_2(int[] data) {
        int n = data.length;
        int start = data[n-1];
        int all = data[n-1];
        for (int i = n-2; i >= 0; i--) {
            start = Math.max(data[i], start+data[i]);
            all = Math.max(start, all);
        }
    }

    private static int method_1(int[] data) {
        int[] start = new int[data.length];
        int[] all = new int[data.length];
        int n = data.length;
        start[n-1] = data[n-1];
        all[n-1] = data[n-1];
        for (int i = n-2; i >= 0; i--) {
            all[i] = threeMax(all[i+1], data[i]+start[i+1], data[i]);
        }
        return all[0];
    }

    
    
    
    private static int threeMax(int x, int y, int z) {
        if (x >= y && x >= z)  {
            return x;
        }else {
            return (y>=z?y:z);
        }
    }
}