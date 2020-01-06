/**
 * MaxWaterContainer
 */
public class MaxWaterContainer {

    public static void main(String[] args) {
        int[] hights = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(hights);
        System.out.print(ans);
    }

    private static int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while (left < right) {     
            res = Math.max(res, (right- left)* Math.min(height[left], height[right]));      
            //判断一下此时的高度瓶颈在左还是右
            if (height[left] < height[right]) { 
                left++;
            }else if (height[left] > height[right]) {
                right--;
            }else {
                left++;
                right--;
            }
            
        }
        return res;
    }
}