import java.util.ArrayList;

public class SumZuHe {
    static int sum = 2;
    static ArrayList<Integer> ansList = new ArrayList<>();
    public static void main(String[] args) {
        int[] A = {4, 4, 3};
        int[] B = {-1, 1, -1};
        method_1(A, B, 0, new ArrayList<Integer>());
        for (Integer var : ansList) {
            //System.out.print(var+" ");
            if (var == sum ) {
                System.out.println("1");
                return;
            }
        }
        //System.out.println();
        System.out.println("0");
    }

    private static void method_1(int[] a, int[] b, int index, ArrayList<Integer> list) {
        int s = 0;
        if (index == a.length) {
            for (Integer var : list) {
                s += var;
            }
            ansList.add(s);
            return;
        }

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    list.add(a[index]);
                    break;
                case 1:
                    list.add(b[index]);
                    break;
                case 2:
                    list.add(a[index] * b[index]);
                    break;
                default:
                    break;
            }
            method_1(a, b, index+1, list);
            list.remove(list.size()-1);
        }
    }
}