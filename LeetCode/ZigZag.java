/**
 * ZigZag
 */
public class ZigZag {

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        String ans = convert(s, numRows);
        System.out.println(ans);
    }

    private static String convert(String s, int numRows) {
        char[] chars = s.toCharArray(); 
        int len = s.length();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int index = 0; index < numRows; index++) {
            sbs[index] = new StringBuilder();
        }
        int i = 0;
        while (i<len) {
            for (int index = 0; index < numRows && i < len; index++) {
                sbs[index].append(chars[i++]);
            }

            for (int index = numRows-2; index >=1 && i < len; index--){
                sbs[index].append(chars[i++]);
            }
        }
        for (int index = 1; index < numRows; index++) {
            sbs[0].append(sbs[index]);
        }
        return sbs[0].toString();
    }
}