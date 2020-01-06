import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStreamReader;
public class Bag {
    
    public static void main(String[] args) throws IOException{
        //System.out.println("jaja");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read();  //n个物品；
        int V = br.read();  //背包容量为V;
        
        ArrayList<Integer> flags = new ArrayList<>();  // flags[i], 物品i是否可以有多个
        ArrayList<Integer> w = new ArrayList<>(); //w[i] , 物品i的价值
        ArrayList<Integer> v = new ArrayList<>(); //v[i], 物品i的体积
        for (int i =0; i<n; i++) {
            String[] split = br.readLine().split(" ");
            flags.add(Integer.parseInt(split[0]));
            w.add(Integer.parseInt(split[1]));
            v.add(Integer.parseInt(split[2]));
        }
        System.out.println(getAnswer(n, V, flags, w, v));   
    }

	private static int getAnswer(int n, int V, ArrayList<Integer> flags, ArrayList<Integer> w, ArrayList<Integer> v) {
        int[] dp = new int[V+1];    //背包重量为0到背包重量为V，所能装的最大价值
        for (int i = 0; i< n; i++) {    
            if (flags.get(i) == 0) {    //01背包  从右往左
                for (int j= V; j >= v.get(j); j--) {
                    dp[j] = Math.max(dp[j], dp[j-v.get(i)]+w.get(i));
                }
            }else { // 完全背包
                for (int j = v.get(i); j<=V; j++) {
                    dp[j] = Math.max(dp[j], dp[j-v.get(i)]+w.get(i));
                }
            }
        }
        return dp[V];
	}
}

class Bag2 {
    static final int MAX_capacity = 5000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read();  //物品数量
        int[][] preBag = new int[n+5][MAX_capacity+5];
        int[][] postBag = new int[n+5][MAX_capacity+5];
        int[] vol = new int[n+1];  // 用【1，n]  vol[n]表示第n个物品的体积
        int[] value = new int[n+1]; 
        for(int i = 1; i<=n; i++) {
            String[] split = br.readLine().split(" ");
            vol[i] = Integer.parseInt(split[0]);
            value[i] = Integer.parseInt(split[1]);
        }
        int q = br.read();  //问题数目
        int[] qV = new int[q];  //qV[i]  第i个问题背包重量
        int[] qX = new int[q];  //qX[i]  第i个问题去掉的背包索引【1，n】
        ArrayList<Integer> ans = new ArrayList<>(); //存放每个问题的结果
        for (int i = 0; i < q; i++) {
            String[] split = br.readLine().split(" ");
            qV[i] = Integer.parseInt(split[0]);
            qX[i] = Integer.parseInt(split[1]);
        }
        for (int i = 1; i<=n; i++) {
            for (int j = 0; j<vol[i]; j++) {
                preBag[i][j] = preBag[i-1][j];
            }
            for (int j = vol[i]; j <= MAX_capacity; j++) {
                preBag[i][j] = Math.max(preBag[i-1][j], preBag[i-1][j-vol[i]]+value[i]);
            }
        }
        for (int i=n; i>=1; i--) {
            for (int j = 0; j<vol[i]; j++) {
                postBag[i][j] = preBag[i+1][j];
            }
            for (int j = vol[i]; j <= MAX_capacity; j++) {
                preBag[i][j] = Math.max(preBag[i+1][j], preBag[i+1][j-vol[i]]+value[i]);
            }
        }
        for (int i = 0; i < q; i++) {
            int mx = 0;
            for (int j = 0; j <= qV[i]; j++) {
                mx = Math.max(preBag[qX[i]-1][j], postBag[qX[i]+1][qV[i]-j]);
            }
            ans.add(mx);
        }
    }
}