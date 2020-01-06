import java.util.ArrayList;
import java.util.Arrays;

public class RightTwoDigit {
    public static void main(String[] args) {
        int[] data = new int[10];
        int sum = 0;
        method_1(data, sum);
        method_2(data, sum);
    }

    private static ArrayList<ArrayList<Integer>> method_2(int[] data, int sum) {
        ArrayList<Integer> tempList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(data);
        for (int i = 0, j=data.length; i < j; ) {
            if (data[i] + data[j] == sum) {
                tempList.add(data[i]);
                tempList.add(data[j]);
                list.add(tempList);
                tempList.clear();
            }else if(data[i] + data[j] < sum) {
                i++;
            }else {
                j--;
            }
        }
        return list;
    }

    private static ArrayList<ArrayList<Integer>> method_1(int[] data, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = i+1; j < data.length; j++) {
                if (sum == (data[i] + data[j])) {
                    tempList.add(data[i]);
                    tempList.add(data[j]);
                    list.add(tempList);
                    tempList.clear();
                }
            }
        }
        return list;
    }
}