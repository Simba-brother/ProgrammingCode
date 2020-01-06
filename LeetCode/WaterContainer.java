/**
 * WaterContainer
 * https://blog.csdn.net/qq_17550379/article/details/84945427
 */
public class WaterContainer {

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};  //ans = 6
        // int ans = method_1(heights);
        // System.out.println(ans);

        // int ans = method_2(heights);
        // System.out.println(ans);

        int ans = method_3(heights);
        System.out.println(ans);
    }
    //仅仅对撞指针， 只能根据两端来定哪个柱子可以确定
    //相比较与method_2，他需要根据左右两端maxLeft和maxRight的值来确定
    private static int method_3(int[] heights) {
        int res = 0;
        int left = 0;
        int right = heights.length-1;
        int maxLeft  = 0;
        int maxRight = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                if (heights[left] > maxLeft) {
                    maxLeft = heights[left];
                }else {
                    res += maxLeft - heights[left];
                }
                left++;
            }else {
                if (heights[right] > maxRight) {
                    maxRight = heights[right];
                }else {
                    res += maxRight - heights[right];
                    right--;
                }
            }
        }
        return res;
    }

    // 先找出最高位置
    //因为找出了全局最高，所以分2段去算就可以了， 不需要比较左右两端的maxLeft
    private static int method_2(int[] heights) {
        int res = 0;
        int peek = 0;
        int heightest = heights[0];
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > heightest) {
                heightest = heights[i];
                peek = i;
            }
        }
        int maxLeft = heights[0];
        int maxRight = heights[heights.length-1];
        for (int i = 0; i < peek; i++) {
            if (heights[i] > maxLeft) {
                maxLeft = heights[i];
            }else {
                res += (maxLeft - heights[i]);
            }
        }
        for (int i = heights.length-1; i > peek; i--) {
            if (heights[i] > maxRight) {
                maxRight = heights[i];
            }else {
                res += maxRight - heights[i];
            }
        }
        return res;
    }

    /** 最暴力方法O(n^2) 
     *单独算每一个柱子头顶所能存的水量， 算每一个柱子的时候都要遍历一遍数组所以拿n*n的时间复杂度 
    */
    private static int method_1(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < heights.length-1; i++) {
            int leftMaxHigh = 0;
            int rightMaxHigh = 0;
            for (int left = 0; left <= i; left++) {
                leftMaxHigh = Math.max(heights[left], leftMaxHigh);
            }
            for (int right = i; right < heights.length; right++) {
                rightMaxHigh = Math.max(rightMaxHigh, heights[right]);
            }
            res += Math.min(leftMaxHigh, rightMaxHigh) - heights[i];
        }
        return res;
    }
}