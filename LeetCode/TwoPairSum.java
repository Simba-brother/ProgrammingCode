
import java.util.HashMap;
  
public class TwoPairSum {
    public static void main(String[] args) {
        int nums[] = {1, 2, 9, 7, 5};
        int target = 9;
        int[] res = twoSum(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

	private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        //key:遍历的number, val:该number在nums中对应的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int pairNumber = target - number;
            if (map.containsKey(pairNumber)) {
                res[0] = map.get(pairNumber);
                res[1] = i;
                return res;
            }else {
                map.put(number, i);
            }
        }
        return res;
	}

}