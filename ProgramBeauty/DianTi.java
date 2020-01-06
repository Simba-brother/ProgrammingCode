import java.util.Scanner;

public class DianTi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //楼层数 
        int[] person = new int[n+1]; // 从1开始
        int walkFloor = 0;
        int minWalkFloor = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                walkFloor += person[j]*(i-j);
            }   
            
            for (int j = i+1; j <= n; j++) {
                walkFloor += person[j]*(j-i);
            }
            minWalkFloor = Math.max(minWalkFloor, walkFloor);
        }

    }
    public static int method2(int[] person, int n) {
        int targetFloor =1;
        int minFloor = Integer.MAX_VALUE;
        int N1  =0;
        int N2 = person[1];
        int N3 = 0;
        for (int i = 2; i <= n; i++) {
            N3 += person[i];
            minFloor += person[i]*(i-1);
        }
        for (int i = 2; i <= n; i++) {
            if (N1 + N2 < N3) {
                targetFloor = i;
                minFloor += N1 + N2 -N3;
                N1 += N2;
                N2 = person[i];
                N3 -= person[i];
            }
            break;
        }
        return 0;            
    }

}