import java.util.Arrays;

public class BuyBook {
    static int Max= 100000;
    static int[][][] MinMoney = new int[100][100][100];
    static int count;
    public static void main(String[] args) {
        int x = 2; 
        int y = 5; 
        int z = 8;
        System.out.println(minMoney(x, y, z)); 
        System.out.println(count);

    }

    private static int minMoney(int x, int y, int z) {
        count++;
        int[] books = {x, y, z};
        Arrays.sort(books);
        x=  books[2];
        y = books[1];
        z = books[0];
        if (MinMoney[x][y][z] != 0) {
            return MinMoney[x][y][z];
        }
        if (x == 0) {
            return 0;
        }else if(z >= 1) {
            MinMoney[x][y][z] = min(MinMoney[x-1][y-1][z-1]+255, MinMoney[x-1][y-1][z]+180, MinMoney[x-1][y][z]+95);
        }else if(y>=1) {
            MinMoney[x][y][z] = min(Max, MinMoney[x-1][y-1][z]+180, MinMoney[x-1][y][z]+95);
        }else if (x>=1) {
            MinMoney[x][y][z] = min(Max, Max, MinMoney[x-1][y][z]+95);
        }
        return MinMoney[x][y][z];
    }

    private static int min(int i, int j, int k) {
        if (i<=j&&j<=k) {
            return i;
        }else {
            return j<k?j:k;
        }
    }
}