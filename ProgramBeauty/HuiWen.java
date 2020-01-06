import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuiWen {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ans = countHuiWen(str);
        System.out.println(ans);
    }

    private static int countHuiWen(String str) {
        int baseCount = str.length();   //基数
        int count = 0;
        for (int i = 1; i < str.length()-1; i++) {      // [1, 倒数第2个]
            int pre = i-1;  //前指针的初始化
            int next = i+1; //后指针的初始化
            if (str.charAt(i) == str.charAt(pre)) { //如果当前指针和前指针相等
                count++;
            }
            //不等的话看前后
            while (pre >= 0 && next <= str.length()-1) {
                if (str.charAt(pre) == str.charAt(next)) {
                    count++;
                    pre--;
                    next++;
                }else { //如果前后不等于的话 退出循环
                    break;
                }
            }
           
        }
        return count+baseCount;
    }
}