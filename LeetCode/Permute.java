import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/**
 * Permute
 */
public class Permute {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //输出并观看测试
        List<List<Integer>> lists = permute(nums);
        for (List<Integer> every_list : lists) {
            for (Integer var : every_list) {
                System.out.print(var+" ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        //结果集合
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curList =new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        //参数合法性判断
        if (nums.length == 0 || nums == null) {
            return res;
        }
        permuteHelp(res, nums, curList, set);
        return res;
    }

    private static void permuteHelp(List<List<Integer>> res, int[] nums, List<Integer> curList, HashSet<Integer> set) {
        if (curList.size() == nums.length) {
            res.add(new LinkedList<Integer>(curList));  //复制curList, 这是一个注意点
            return;
        }
        for (int i = 0; i < nums.length; i++) { //总共这么多种选择, "方向"
            if (!set.contains(nums[i])) {  //方向有效性， 剪分支
                curList.add(nums[i]);
                set.add(nums[i]);
                permuteHelp(res, nums, curList, set);  //下一层 的方向选择
                curList.remove(curList.size()-1);   //当前层方向删除
                set.remove(nums[i]);    //set也要删除
            }
        }
        //return res;
    }
}