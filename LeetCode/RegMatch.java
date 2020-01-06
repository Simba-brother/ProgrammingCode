/**
 * RegMatch
 */
public class RegMatch {
    public static void main(String[] args) {
        String s = "abcd";
        String p = "a.c*d";
        boolean res = isMatch(s, p);
        System.out.println(res);
    }

    private static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];  //s串作为行, p串作为列
        
        //初始化dp状态二维数组
        dp[0][0] = true;
        //dp第0列的初始化
        for (int row = 1; row < dp.length; row++) {
            dp[row][0] = false;
        }
        //dp第0行的初始化
        for (int col = 1; col < dp[0].length; col++) {
            if (p.charAt(col-1) == '*') {
                dp[0][col] = dp[0][col-2];  //这里一定不会溢出的，因为p串的首字符一定不是‘*’
            }else {
                dp[0][col] = false; //仅仅为了逻辑完整性
            }
        }

        //一行一行的填
        for (int row = 1; row < dp.length; row++) {  //当前行
            for(int col = 1; col < dp[0].length; col++) {
                if (p.charAt(col-1) == '.' || p.charAt(col-1) == s.charAt(row-1)) {
                    dp[row][col] = dp[row-1][col-1];
                }else if (p.charAt(col-1) == '*') {
                    if (p.charAt(col-2) == s.charAt(row-1) || p.charAt(col-2) == '.') {
                        dp[row][col] = dp[row-1][col] || dp[row][col-2];
                    }else {
                        dp[row][col] = dp[row][col-2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}