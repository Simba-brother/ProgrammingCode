import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * PermutationII
 */
public class PermutationII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);  //”同一个“方向紧邻
        //结果集
        List<List<Integer>> res = new LinkedList<>();
        //当前集
        List<Integer> curList = new LinkedList<>();
        //访问标志数组
        boolean[] used = new boolean[nums.length];
        // res被填充
        permuteUniqueHelp(nums, res, curList, used);  
        return res;
    }

    private static void permuteUniqueHelp(int[] nums, List<List<Integer>> res, List<Integer> curList,
            boolean[] used) {
        //递归出口，如果当前集合==nums.length
        if (curList.size() == nums.length) {  //其实就是递归到了nums.length层，就要返回了
            res.add(new LinkedList<Integer>(curList));
        }else { // 否则
            int preNum = nums[0]-1;     //因为排过序， 所以nums[0]-1绝对不会出现在nums[i]中！
            //每一层的n个方向
            for (int i = 0; i < nums.length; i++) {
                if (preNum != nums[i] && used[i] == false) {
                    used[i] = true; //i这个方向设置为访问过，以后都不能再去选择了
                    curList.add(nums[i]);//当前层的方向数据加入，深入到下一层
                    preNum = nums[i];   //该层的方向数据存下
                    permuteUniqueHelp(nums, res, curList, used);
                    //上一层的结果返回以后(所谓的回溯)，当前层此时的方向需要重新被设置！！！，
                    used[i] = false;
                    curList.remove(curList.size()-1);    
                }
            }
        }
    }
}