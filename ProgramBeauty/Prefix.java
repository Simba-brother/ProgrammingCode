import java.util.ArrayList;

public class Prefix {
    static ArrayList<ArrayList<String>> resList = new ArrayList<>();
    static int[] log;
    public static void main(String[] args) {
        String target = "ababc";
        String[] data = {"a", "b", "ab", "c"};
        int begin = 0;
        int end = target.length()-1;
        // ArrayList<String> list = new ArrayList<>();
        // method(target, data, begin, end, list);
        // System.out.println(resList.size());

        // log = new int[target.length()+1];   //log数组要比target数组下标索引大一
        // for (int i = 0; i < log.length; i++) {
        //     log[i] = -1;
        // }
        // int ok = method_2(target, data, begin, end);
        // System.out.println(ok);
        
        log = new int[target.length()+1];
        for (int i = 0; i < log.length; i++) {
            log[i] = -1;
        }
        int ok = method_3(target, data, log);
        System.out.println(ok);
    }
    
    /**
     * 
     * @param target 目标串
     * @param data  方向
     * @param log   记录曾经
     */
    private static int method_3(String target, String[] data, int[] log) {
        if (log[target.length()] != -1) {
            return log[target.length()];
        }
        int res = 0;
        for (int i = 0; i < data.length; i++) {
            if (target.equals(data[i])) {
                res = 1;
                continue;
            }
            if (target.startsWith(data[i])) {
                res += method_3(target.substring(data[i].length()), data, log);   
            }
        }
        log[target.length()] = res;
        return res;
    }

    /**
     * 
     * @param target 目标串
     * @param data   数据数组
     * @param begin  串的开始索引
     * @param end    目标串的最后一个索引
     * @return
     */
    private static int method_2(String target, String[] data, int begin, int end) {
        if (log[begin] != -1) {
            return log[begin];
        }
        int res = 0;    //该递归算法的返回变量
        if (begin > end) {  //如果begin超过了target最后一个字符，说明找到一条路径
            res = 1;    
        }
        for (String candidate : data) { // 所有的方向
            if (target.substring(begin).startsWith(candidate)) { //如果这个方向可以
                res += method_2(target, data, begin+candidate.length(), end);   //层数++， 注意跟二叉树深度不同， 层数增加一时， res并不++
            }
        }
        log[begin] = res;   //保存该层结果
        return res;
    }

    /**
     * 
     * @param target 目标串
     * @param data  数据数组
     * @param begin 串的开始索引
     * @param end   目标串的最后一个索引
     * @param tempList  记录下走过的合法深度路径
     */
    private static void method(String target, String[] data, int begin, int end, ArrayList<String> tempList) {
        if (begin > end) {
           resList.add(tempList);   // 把这一整条路径加到结果集合中
           return;
        }
        for (int i = 0; i < data.length; i++) { //方向
            if (target.substring(begin).startsWith(data[i])) { //验证方向合法性
                tempList.add(data[i]);  //如果合法将方向加入
                method(target, data, begin+data[i].length(), end, tempList); //深入下一层
                tempList.remove(tempList.size()-1); //回溯，也就是该方向移除准备实验下一个方向
            }
        }
    }
}