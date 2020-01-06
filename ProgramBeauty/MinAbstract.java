public class MinAbstract {
    public static void main(String[] args) {
        String src = "1234522637";
        String s2 = "232";
        System.out.println(method(src, s2));   
    }

    private static String method(String src, String s2) {
        int len = src.length();
        int pBegin =0;
        int pEnd = 0;
        int resBegin =0;
        int resEnd = 0;
        while (true) {
            if (pEnd < len && !isAllExited(src.substring(pBegin, pEnd+1),s2)) {
                pEnd++;
            }          
            while (isAllExited(src.substring(pBegin, pEnd+1),s2)) {
                if (len > pEnd-pBegin+1) {
                    len = pEnd-pBegin+1;
                    resBegin = pBegin;
                    resEnd = pEnd;
                }
                pBegin++;
            } 
            if (pEnd >= len) {
                break;
            }
        }
        return src.substring(resBegin, resEnd+1);
    }
    /**
     * s1中的字符是否含有s2中的所有字符
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isAllExited(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            if (s1.indexOf(s2.charAt(i)) == -1) {   //如果s2中的某一个字符在s1中不存在 返回false, 如果遍历完s2还没有false 则return true
                return false;
            }
        }
        return true;
    }
}