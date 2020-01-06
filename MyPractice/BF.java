public class BF {
    public static void main(String[] args) {
        String inputString = "www.fishc.com";
        String patternString = "fish";
        //int index = getAnswer(inputString, patternString);
        int index_2 = getAnswer_2(inputString, patternString);
        System.out.println(index_2);
    }

    private static int getAnswer_2(String inputString, String patternString) {
        int i = 0;  //inputString下标
        int j = 0; // patternString下标
        while (i<inputString.length()) {
            if (inputString.charAt(i) == patternString.charAt(j)) {
                j++;
                i++;
                if (j == patternString.length()) {
                    return i - patternString.length();
                }
            }else {
                j = 0;
                i = i - j+1;
            }
        }
        return -1;
    }

    private static int getAnswer(String inputString, String patternString) {
        int j =0;   //pattern索引
        for (int i = 0; i < inputString.length(); ) {   //inputString索引
            if (inputString.charAt(i) == patternString.charAt(j)) {
                i++;
                j++;
                if (j == patternString.length()) {
                    return i - patternString.length();
                }
            }else {
                i = i - j+1;
                j = 0;
            }
        }
        return -1;
    }
}