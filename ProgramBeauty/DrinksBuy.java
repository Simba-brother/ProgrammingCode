import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrinksBuy {
    static class Drink {
        String name;//饮料的名字名字
        int capacity;//单位饮料的容量，单位：L
        int maxNumber;//可供应饮料的最大数量，单位：个
        int happiness;//对单位饮料的满意度
        int purchaseNumber;//对饮料的实际购买数量，单位：个

        /**
         * @param name
         * @param capacity
         * @param maxNumber
         * @param happiness
         * @param purchaseNumber
         */

        public Drink(String name, int capacity, int maxNumber, int happiness, int purchaseNumber) {
            this.name = name;
            this.capacity = capacity;
            this.maxNumber = maxNumber;
            this.happiness = happiness;
            this.purchaseNumber = purchaseNumber;
        }

        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read();  //有多少中饮料
        Drink[] drinks = new Drink[n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            String name = split[0];
            int capacity = Integer.parseInt(split[1]);
            int maxNumber = Integer.parseInt(split[2]);
            int happiness = Integer.parseInt(split[3]);
            int purchaseNumber = Integer.parseInt(split[4]);
            Drink drink = new Drink(name, capacity, maxNumber, happiness, purchaseNumber);
            drinks[i] = drink;
        }
        int totalCapicity = br.read();  //背包容量
        getMaxSatisfy(drinks, totalCapicity);
    }

    public static int getMaxSatisfy(Drink[] drinks, int totalCapicity) {
        int theNumberofGoods = drinks.length;
        int[][] satisfy = new int[theNumberofGoods+1][theNumberofGoods+1];
        int[][] state = new int[theNumberofGoods+1][theNumberofGoods+1];
        // for (int i = 0; i < satisfy.length; i++) {
        //     satisfy[0][i] = 0;
        // }
        // for (int j = 0; j < satisfy.length; j++) {
        //     satisfy[j][0] = 0;
        // }
        for (int i = 1; i <= theNumberofGoods; i++) {
            for (int j = 1; j <=  totalCapicity; j++) {
                int maxHappiness = 0;
                int purchaseNumber = 0;
                for (int k = 0; k <=  drinks[i-1].maxNumber; k++) {
                    if (drinks[i-1].capacity * k > j) {
                        break;
                    }
                    int temp = 0;
                    temp = satisfy[i-1][j - drinks[i-1].capacity] + k*drinks[i-1].happiness;
                    if (temp > maxHappiness) {
                        maxHappiness = temp;
                        purchaseNumber = k;
                    }
                }
               satisfy[i][j] = maxHappiness;
               state[i][j] = purchaseNumber;
            }    
        }

        for (int i = 0; i <= theNumberofGoods; i++) {
            for (int j = 0; j <= totalCapicity; j++) {
                System.out.print(satisfy[i][j] + " ");
            }
            System.out.println();
        }
        int[] buy = new int[theNumberofGoods];
        getAndPrintBuy(drinks, state, buy, totalCapicity);
        return satisfy[theNumberofGoods][totalCapicity];
    }

    public static void getAndPrintBuy(Drink[] drinks, int[][] state, int[] buy, int totalCapicity) {
        int theNumberofGoods = buy.length;
        for(int i = theNumberofGoods - 1; i >= 0; i--) {
            if (totalCapicity == 0) {
                break;
            }
            int k = state[i+1][totalCapicity];
            buy[i] = k;
            totalCapicity -= (k * drinks[i].capacity);
        }
        System.out.println("饮料购买方案为：");
        for(int i = 0; i < theNumberofGoods; i++){
            System.out.println("饮料名：" + drinks[i].name+"  购买数量: "+buy[i]);
           // cout << "饮料名：" << goods[i].name << " 购买数量："<< buy[i] << endl;
        }
    }
}
