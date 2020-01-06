import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ThreeSum
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> allList = threeSum(nums);
        System.out.println(allList);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;    
        }
        Arrays.sort(nums);
        List<List<Integer>> resultList = new LinkedList<>();

        int i = 0; //base数的指针
        while (i < nums.length-2) {  //base数的指针的右边界
            int base = nums[i];
            int left = i+1;  //以i为base时的左指针
            int right = nums.length-1; //以i为base时的右指针
            while (left < right) {
                int sum = base + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> tempList = new LinkedList<>();
                    tempList.add(base);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);    
                    resultList.add(tempList);
                    left = moveRight(nums, left+1);
                    right = moveLeft(nums, right-1);
                }else if (sum > 0) {
                    right = moveLeft(nums, right-1);
                }else {
                    left = moveRight(nums, left+1);
                }
            }
            i = moveRight(nums, i+1);
        }
        return resultList;
    }

    private static int moveLeft(int[] nums, int nextLeftIndex) {
        while (nextLeftIndex == nums.length-1 || (nextLeftIndex >= 0) && nums[nextLeftIndex] == nums[nextLeftIndex+1] ) {
            nextLeftIndex--;
        }
        return nextLeftIndex;
    }

    private static int moveRight(int[] nums, int nextRightIndex) {
        while (nextRightIndex == 0 || (nextRightIndex < nums.length && nums[nextRightIndex] == nums[nextRightIndex-1]) ) {
            nextRightIndex++;
        }
        return nextRightIndex;
    }
}