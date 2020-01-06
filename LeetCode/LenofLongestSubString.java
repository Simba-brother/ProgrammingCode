public class LenofLongestSubString {
    public static void main(String[] args) {
        String data = "abcdbe";
        int res = getAnswer(data);
        System.out.println(res);
    }

    private static int getAnswer(String s) {
        boolean[] used = new boolean[128];
        int maxLen = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (used[s.charAt(right)] == false) {
                used[s.charAt(right)] = true;
                right++;
            }else {
                maxLen = Math.max(maxLen, right-left);
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        maxLen = Math.max(maxLen, right-left);
        return maxLen;
    }
}