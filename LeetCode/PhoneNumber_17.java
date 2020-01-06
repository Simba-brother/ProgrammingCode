import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * PhoneNumber_17
 */
public class PhoneNumber_17 {

    
    public static void main(String[] args) {
        String nums = "23";
        //List<String> ans = letterCombinations(nums); //dfs
        List<String> ans2 = letterCombinations2(nums); //bfs
        //System.out.println(ans);
        System.out.println(ans2);
    }

    private static List<String> letterCombinations2(String digits) {
        //结果集合
        LinkedList<String> queue = new LinkedList<>(); 
        //参数合法性判断
        if (digits == null || digits.length() == 0 ) {
            return queue;
        }
        //数字与字符的映射关系
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        queue.addLast("");
        help2(digits, map, queue);
        return queue;
    }

    /**
     * 
     * @param digits 电话号码， 电话号码总长就是层数
     * @param map   数字与字符的映射关系
     * @param queue 用于bfs
     */
    private static void help2(String digits, HashMap<Character, char[]> map, LinkedList<String> queue) {
        for (int i = 0; i < digits.length(); i++) {
            int sizeOfQueue = queue.size();
            for (int j = 0; j < sizeOfQueue; j++) {
                String str = queue.pollFirst();
                for (char ch : map.get(digits.charAt(i))) {
                   
                    String curString = str+ch;
                    //System.out.println(curString);
                    queue.addLast(curString);
                }
            }
        }
    }

    private static List<String> letterCombinations(String digits) {
        //结果集合
        List<String> list = new LinkedList<>(); 
        //参数合法性判断
        if (digits == null || digits.length() == 0 ) {
            return list;
        }
        //数字与字符的映射关系
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        help("", digits, 0, map, list);
        return list;
    }

    /**
     * 
     * @param curString 每一层续过来的方向值存这里     初始值==“”
     * @param digits    电话号码，有几个电话号码递归就有多少层，每一层都有一些方向
     * @param index 电话号码的索引， 也就是递归层数   初始值==0
     * @param map   数字与字符的映射关系
     * @param list  结果集合，递归到最后一层时list.add(curString)  初始值==[]
     */
    private static void help(String curString, String digits, int index, HashMap<Character, char[]> map, List<String> list) {
        if (index == digits.length()) { //如果递归完所有层了
            list.add(curString);
        }else {
            char numKey = digits.charAt(index);
            // if (map.containsKey(numKey)) {
            //     for (char ch : map.get(numKey)) {
            //         //curString += ch;
            //         //深度到下一层 该层方向值添加：curString+ch, 层数+1: index+1
            //         help(curString+ch, digits, index+1, map, list);               
            //     }                
            // }
            for (char ch : map.get(numKey)) {
                //curString += ch;
                //深度到下一层 该层方向值添加：curString+ch, 层数+1: index+1
                help(curString+ch, digits, index+1, map, list);               
            } 
        }
    }
}