public class Bag {
    public static void main(String[] args) {
        int V = 10;
        int N = 10;
        int[] weights = new int[N];
        int[] values = new int[N];
        
        zeroOnePackage(V, N, weights, values); //0-1背包
        youHuaZeroOnePackage(V, N, weights, values);    //空间优化的0-1背包
        int[] numbers = new int[N]; //N个种类的物品每种有几个
        manyPackage(V, N, weights, values, numbers);    //多重背包
        completePackage(V, N, weights, values); //完全背包
        youHuaCompletePackage(V, N, weights, values);   //空间优化的完全背包
    }

    /**
     * 
     * @param V 包重
     * @param N 物品种类
     * @param weights   物品重量数组
     * @param values    物品价值数组
     * @return
     */
    private static int youHuaCompletePackage(int V, int N, int[] weights, int[] values) {
        int[] dp = new int[V+1];
        for (int i = 1; i <= N; i++) {
            for (int j = weights[i-1]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j-weights[i-1]]);
            }
        }

        return dp[V];
    }

    /**
     * 
     * @param V       包重
     * @param N       物品种类
     * @param weights 物品的重量数组
     * @param values  物品的价值数组
     */
    private static int completePackage(int V, int N, int[] weights, int[] values) {
        int[][] dp = new int[N+1][V+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (weights[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[N][V];
    }

    /**
     * 
     * @param V       背包容量
     * @param N       物品种类数量
     * @param weights 物品的重量数组
     * @param values  物品的价值数组
     * @param numbers 每种物品个数数组
     */
    private static int manyPackage(int V, int N, int[] weights, int[] values, int[] numbers) {
        int[][] dp = new int[N+1][V+1]; 
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= N; j++) {
                if (weights[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    int temp = Math.min(numbers[i-1], j/weights[i-1]);  //物品i可选的个数
                    for (int k = 0; k <= temp; k++) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - k*weights[i-1]]+values[i-1]*k);
                    }
                }
            }
        }  
        return dp[N][V];      
    }

    /**
     * 
     * @param V       包容量
     * @param N       物品数量
     * @param weights 物品重量数组
     * @param values  物品价值数组
     */
    private static int youHuaZeroOnePackage(int V, int N, int[] weights, int[] values) {
        int[] dp = new int[V+1];
        for (int i = 1; i <= N; i++) {  //物品索引
            //现在物品定了，只需要遍历比物品体积大的包容量，因为是从V开始所以V容量前的包裹是没有装物品i的，
            for (int j = V; j > weights[i-1]; j--) {    
                dp[j] = Math.max(dp[j], dp[j-weights[i-1] + values[i-1]]);
            }
        }
        return dp[V];
    }

    /**
     * 
     * @param V       包容量
     * @param N       物品数量
     * @param weights 物品重量数组
     * @param values  物品价值数组
     */
    private static int zeroOnePackage(int V, int N, int[] weights, int[] values) {
        int[][] dp = new int[N+1][V+1];
        for (int i = 1; i <= N; i++) {  //物品遍历
            for (int j = 1; j <= V; j++) { //对于每一个物品，遍历包
                if (weights[i-1] > j) {  //如果此时物品的重量大于 包容量
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[N][V];
    }


}