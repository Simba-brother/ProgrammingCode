
public class Sort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
        //bubbleSort(nums);
        //selectSort(nums);
        //insertSort(nums);
        //quickSort(nums, 0, nums.length-1);
        mergeSort(nums, 0 , nums.length-1);
        for (int i = 0; i<10; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start+end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, mid+1, end);
        }
    }

    private static void merge(int[] nums, int start1, int end1, int start2, int end2) {
        int i, j;
        {
            i = start1;
            j = start2;
        }
        int k = 0;
        int[] temp = new int[end2-start1+1];
        while(i<=end1 && j<=end2) {
            if (nums[i] > nums[j]){
                temp[k++] = nums[j++];
            }else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= end1) {
            temp[k++] = nums[i++];
        }
        while(j <= end2) {
            temp[k++] = nums[j++];
        }
        k = start1;
        for (int element : temp) {
            nums[k++] = element;
        }
    }

    private static void quickSort(int[] nums, int low, int high) {
        int i, j, flag;
        if (low < high) {
            i = low;
            j = high;
            flag = nums[i];
            while (i < j) {
                while (i<j && nums[j] > flag) {
                    j--;
                }
                if (i<j) {
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] < flag) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--; 
                }
                nums[i] = flag;
                quickSort(nums, low, i-1);
                quickSort(nums, i+1, high);
            }
        }
    }

    private static void insertSort(int[] nums) {
        for (int i=1; i<nums.length; i++) { // i=1
            for (int j=i; j>0; j--) {
                if (nums[j] < nums[j-1]) {
                    swap(nums, j, j-1);
                }
            }
        }
    }

    private static void selectSort(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] > nums[j]) {  // 选择：如果第一个位置比后面所有位置都大则交换
                    swap(nums, j, i);
                }
            }
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = nums.length-1; i>0; i--) {     //i > 0
            for (int j = 0; j<i; j++) { 
                if (nums[j] > nums[j+1]) {  // 冒泡：如果前一个比后一个大则交换
                    swap(nums, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}