public class LoopRightMoveContains {
    public static void main(String[] args) {
        String str1 = "AABCD";
        String str2 = "CDAA";
        char[] src = str1.toCharArray();  //需要去循环左移动的
        char[] des = str2.toCharArray();
       // boolean result = method_1(src, des);
       // System.out.println(result);
        boolean result = method_2(str1, str2);
        System.out.println(result);
    }

    private static boolean method_2(String str1, String str2) {
        String bigStr1 = str1+str1;
        if (bigStr1.contains(str2)) {
            return true;
        }
        return false;
    }

    private static boolean method_1(char[] src, char[] des) {
        int len = src.length;
        for (int i = 0; i < len; i++) {     // 循环左移动len次就是全部情况了
            char temp = src[0];
            for (int j = 0; j < len-1; j++) {
                src[j]= src[j+1];   //j+1 < len也就时j+1可以走到最后一个字符
            }
            src[len-1] = temp;
            if (String.valueOf(src).contains(String.valueOf(des))) {
                return true;
            }
        }
        return false;
    }
}