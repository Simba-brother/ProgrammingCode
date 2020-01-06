/**
 * KMP
 */
public class KMP {

    public static void main(String[] args) {
        String t = "ababaaa";
        String s = "fababaaas";
        int res = getAnswer(t, s);
        System.out.println(res);
    }

    private static int getAnswer(String t, String s) {
        //在t串前插入一个t串的长度，即t.charAt(0) == 原t串的长度
        StringBuilder sb = new StringBuilder(t);
        sb.insert(0, t.length());
        t = sb.toString();
        //根据模式串得到next数组
        int[] next = get_next(t);
        //在s串前插入一个s串的长度，即s.charAt(0) == 原s串的长度
        StringBuilder sb2 = new StringBuilder(s);
        sb2.insert(0, s.length());
        s = sb2.toString();

        System.out.println(t);
        System.out.println(s);
        int pos = 0;
        int i = 1;
        int j = 1;
        while (i <= Integer.parseInt(s.charAt(0)+"") && j <= Integer.parseInt(t.charAt(0)+"")) {
            if (j == 0 || s.charAt(i) == t.charAt(j)) {
              i++;
              j++;  
            }else {
                j = next[j];
            }        
        }
        if (j>Integer.parseInt(t.charAt(0)+"")) {
            pos = i - Integer.parseInt(t.charAt(0)+"");
            return pos;
        }
        return -1;
    }

    private static int[] get_next(String t) {   
        //i：后缀索引
        //j: 前缀索引
        int i = 1;
        int j = 0;
        int[] next = new int[t.length()];
        next[1] = 0;
        while (i < Integer.parseInt(t.charAt(0)+"")) {
            if (j==0 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
        return next;
    }
}