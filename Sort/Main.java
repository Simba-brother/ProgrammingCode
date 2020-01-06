package Sort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 8, 4, 9, 0};
        int begin = 0;
        int end = a.length-1;
        // quickSort(a, begin, end);
        // System.out.println(Arrays.toString(a));

        // mergeSort(a, begin, end);
        // System.out.println(Arrays.toString(a));

        // bubbleSort(a);
        // System.out.println(Arrays.toString(a));

        // insertSort(a);
        // System.out.println(Arrays.toString(a));

        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void selectSort(int[] a) {
        for (int i =0; i<a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[i]) {  //只要 a[j]小于a[i] 就交换，所以a[i] 位置被确定。
                    swap(a, j, i);
                }
            }
        }
    }

    private static void insertSort(int[] a) {
        for (int i = 1; i < a.length-1; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j-1]) {
                    swap(a, j , j-1);
                    break;
                    
                }
            }
        }
        /* 不用交换的写法
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i-1; j>=0; j--) {
                if (a[j] > temp) {
                    a[j+1] = a[j];
                }
                a[j] = temp;
                break;
            }
        }
        */
    }

    private static void bubbleSort(int[] a) {
        for (int i = a.length-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left+right)/2;
            mergeSort(a, left, mid);
            mergeSort(a, mid+1, right);
            merge(a, left, mid, right);
        }
    }
    
    private static void merge(int[] a, int left, int mid, int right) {
        int p = left;
        int q = mid+1;
        int[] help = new int[right-left+1];
        int index = 0;
        while (p<=mid && q<= right) {
            if (a[p] <= a[q]) {
                help[index++] = a[p++];
            }else {
                help[index++] = a[q++];
            }
        } 
        while (p<=mid) {
            help[index++] = a[p++];
        }
        while(q<=right) {
            help[index++] = a[q++];
        }
        int k = left;
        for (int item : help) {
            a[k++] = item;
        }
    }

    /**
     * 快速排序
     * 
     * @param a
     * @param left
     * @param right
     */
    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            swap(a, i, random.nextInt(j-i+1)+i);
            int flag = a[i]; // 一般用于不交换的情况
            //开始一趟快排序
            while(i < j) {
                while(i<j && a[j]>= a[i]) {  //从右往左
                    j--;
                }
                swap(a, i, j);
                /*不交换写法
                while(i<j && a[j] >= flag) {
                    j--;
                }
                a[i] = a[j];
                */

                while (i<j && a[i]< a[j]) {   //从左往右
                    i++;
                }
                swap(a, i, j);
            }
            quickSort(a, left, i-1);
            quickSort(a, i+1, right);
        }
    }

    private static void swap(int[] a, int i, int j) {
        if (a == null || a.length == 0 || i < 0 || i > a.length-1 || j < 0 || j > a.length -1) {
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}