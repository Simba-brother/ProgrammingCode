import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;



public class FindMaxKnumbers {
    static Random random = new Random();
    static int K = 7;
    static List<Integer> ans = new LinkedList<>();
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        //List<Integer> ansList = getKnumberUserQuickSort(a, K);
        List<Integer> ansList_1 = getKnumberUserHeap(a);
        for (Integer var : ansList_1) {
            System.out.print(var+" ");
        }
    }

    public static List<Integer> getKnumberUserHeap(int[] data) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       // System.out.println(minHeap.size());
        for (int i = 0; i < data.length; i++) {
            if (minHeap.size() < K) {
                minHeap.offer(data[i]);
            }else {
                System.out.println("lala");
                if (data[i] < (int)minHeap.peek()) {
                    continue;   
                }else{
                    minHeap.poll();
                    minHeap.offer(data[i]);
                }
            }
        }
       // System.out.println(minHeap.size());
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll());
        }
        return ans;
    }

    // public static List<Integer> getKnumberUserQuickSort(int[] data, int k) {
    //     if (data == null || data.length == 0) {
    //         return ans;            
    //     }
    //     if (k >= data.length) {
    //         for (int i = 0; i < data.length; i++) {
    //             ans.add(data[i]);
    //         }
    //         return ans;
    //     }
    //     int begin = 0;
    //     int end = data.length-1;
    //     quickSortMethod(data, begin, end);
    //     return ans;
    //}

    // public static void quickSortMethod(int[] data, int begin, int end) {
    //     if (begin < end) {
    //         int left = begin;
    //         int right = end;
    //         int tempIndex = left + random.nextInt(right-left+1);
    //         swap(left, tempIndex, data);
    //         int flag = data[left];
    //         while (left < right) {
    //             while (right > left && data[right] <= flag) {
    //                 right--;
    //             }
    //             if (right > left) {
    //                 data[left] = data[right];
    //             }
    //             while (right > left && data[left] > flag) {
    //                 left++;
    //             }
    //             if (right > left) {
    //                 data[right] = data[left];
    //             }
    //         }
    //         data[left] = flag;
    //         if (left == K) {
    //             for (int i = 0; i < K; i++) {
    //                 ans.add(data[i]);
    //             }
    //             return;
    //         }else if (left > K) {
    //             quickSortMethod(data, begin, left-1);
    //         }else {
    //             quickSortMethod(data, left+1, end);
    //         }
    //     }
    // }

    // public static void swap(int left, int right, int[] arrays) {
    //     if (arrays.length == 0 || arrays == null || left <0 || right >= arrays.length) {
    //         return;
    //     }
    //     int temp = arrays[left];
    //     arrays[left] = arrays[right];
    //     arrays[right] = temp;
    // }
}