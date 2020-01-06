import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DoubleStone {
    public static void main(String[] args) {
        String str = nim(15, 9);    //两堆石子，第一堆有15个第2堆有9个
        System.out.println(str);
    }

    public static String nim(int x, int y) {
        if (x == y) {
            return "我先取，有策略，我一定能赢"; //如果两堆的大小是一样的，我直接取光。
        }
        if (y > x) {    //如果x小于y 则交换x, y
            int temp = x;
            x = y;
            y = temp;
        }
        int a = 1;  //代表an
        List<Integer> list_a = new ArrayList<>();
        List<Integer> list_b = new LinkedList<>();
        list_a.add(1);
        list_b.add(2);
        int n = 1;      //an中的n, bn = a + n;
        while (a < x) {
            boolean flag =  true;   // 去决定下一个an是多少
            int number = ++a;   //递增a取尝试list_b中是否有
            for (int i = 0; i < list_b.size(); i++) {   //遍历list_b看一下a递增1后是否含有
                if (list_b.get(i) == number) {
                    flag = false;   //发现a递增1 后在list_b中有，则将flag 设为false,意味着a需要继续++
                    break;
                }
            }           
            if (flag == true) {
                n++;
                list_a.add(a);
                list_b.add(a +n);
            }
        }
        //此时a == x或 a > x
        if (a == x) {
            if (list_b.get(list_b.size()-1) == y) { //（x,y）满足一种不安全的情况
                return "我先取，只要对方不是瓜皮，没有， 必胜策略";
            }
        }else {
            return "我先取, 有， 必胜策略";     //因为x没有碰到不安全局面
        }
    }
}