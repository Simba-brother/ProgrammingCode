/**
 * HuiWenInteger
 */
public class HuiWenInteger {

    public static void main(String[] args) {
        int x = 1001;
        boolean res = isPalindrome(x);
        System.out.println(res);
    }

    private static boolean isPalindrome(int x) {
        //如果x小于0 直接返回false
        if (x < 0) {
            return false;
        }
        int num = x;    //x另存为
        int div = 1;    //div初始化为1
        while (num / div >= 10) {    //找到最后一个div，使得num/div得到最高位
            div *= 10;
        }
        while (num > 0) {   //num会被去掉左右两端
            int left = num /div;    //取出最左端
            int right = num %10;    //取出最右端
            if (left != right) {    //判断左右端
                return false;
            }
            num = (num - left*div)/10;  //num被去掉左右两端
            div /= 100; //因为被去掉两端所以div要/100
        }
        return true;
    }
}