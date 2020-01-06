/**
 * CircleIndex
 */
public class CircleIndex {

    public static void main(String[] args) {
        int n = 10; //10个人
        int m = 3; // 从1开始喊每次喊到3的那个人出列

        int last = getAnswer(n, m); //返回最后一个出列的人;
        System.out.println(last);
    }
    /**
     * 
     * @param n  //人数
     * @param m //每次喊到m的那个人出列
     * @return
     */
    private static int getAnswer(int n, int m) {
        int[] arrays = new int[n]; //空间声明
        int baoshu = 0; //报数，初始为0
        int count = n;  //圈中还有几个人
        int index = -1; //被移除人的下一个
        while (count >= 1 ) {  //当我这个圈中的人数>=1时 ，都会执行如下操作
            index++;  // 下一个报数人
            if (index == n) {   //下一个报数人是否到环尾
                index = 0;               
            }
            if(arrays[index] == -1) {   //下一个报数人是否已经出列
                continue;   //如果出列，continue 继续下一个报数人
            }
            baoshu++;   //报数++
            if (baoshu == m) {  //报数如果==m
                count--;    //圈中人数目--
                arrays[index] = -1; //该报数人被移除
                baoshu = 0; //报数归0
            }
        }
        return index;
    }
}