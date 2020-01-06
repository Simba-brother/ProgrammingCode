public class ReversePair {
    public static int count = 0;
    public static int reen = 0;
    public static void main(String[] args) {
        int[] data = {7, 5, 4, 3, 2, 1};
        int begin = 0;
        int end = data.length-1;
        merge(data, begin, end);
        System.out.println(count);
        System.out.println("进入merge的次数 "+reen);
    }

    public static void merge(int[] data, int begin, int end) {
        reen++;
        if (begin < end) {
            int mid = (begin + end) /2;
            merge(data, begin, mid);
            merge(data, mid+1, end);
            mergeSort(data, begin, mid, mid+1, end);
        }
    }

    public static void mergeSort(int[] data, int start1, int end1, int start2, int end2) {
        int[] temp = new int[end2-start1+1];
        int index =0;
        int p = start1;
        int q = start2;
        while (p<= end1 && q<= end2) {
            if (data[p] <= data[q]) {
                temp[index++] = data[p++];
            }else {
                count += (end1+1-p);
                temp[index++] = data[q++];
            }
        } 
        while (p<=end1) {
            temp[index++] = data[p++];
        }           
        while (q<end2) {
            temp[index++] = data[q++];
        }
    }
}