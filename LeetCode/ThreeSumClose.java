import java.util.Arrays;

/**
 * ThreeSumClose
 */
public class ThreeSumClose {

    public static void main(String[] args) {
        int[] nums= {-1, 2, 1, -4};
        int target = 1;
        int ans = threeSumClosest(nums, target);
        System.out.println(ans);
    }

    private static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        //排序数组！！！
        Arrays.sort(nums);
        //dif初始化
        int dif = target - (nums[0] + nums[1] + nums[2]);
        int i = 0;
        while (i < nums.length-2) {
            int left = i + 1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //得到newDif
                int newDif = target - sum;
                //根据newDif的不同值进行逻辑
                if (newDif == 0) {
                    return sum;
                } 
                //满足条件更新dif,  不满足则不更新dif, 最后结果就是 dif+sum
                if (Math.abs(newDif) < Math.abs(dif)) {
                    dif = newDif;
                }
                if (newDif < 0) {   //sum太大
                    right--;
                }else {
                    left++;
                }
            }
            i++;
        }
        return target - dif;
    }
}