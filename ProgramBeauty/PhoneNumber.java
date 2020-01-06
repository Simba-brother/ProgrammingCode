public class PhoneNumber {
    public static void main(String[] args) {
        //0-9数字对应的字符， 用一个数组存 数字和字母 之间的对应关系
        String[] keyboard = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV","WXYZ"};
        //每个数字对应的字母个数
        int[] total = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        //电话号码
        int[] numbers = {2, 6, 6, 7, 8, 8, 3, 7};   //computer     number[i]是keyboard, total, 的下标
        //answer[i]代表第i个号码代表哪个字母（索引）
        int[] answer = new int[10];
        //keyboard[numbers[0]].charAt(answer[0]):代表第0位（最左）电话号所代表的字母
        //method_1(keyboard, total, numbers, answer);
        //method_2(keyboard, total, numbers, answer);

        method_3(total, keyboard, numbers, answer, 0, numbers.length);
    }

    /**
     * 
     *@param numbers 电话号码数组
     * @param answer answer[i], 第i个电话号码对应字符的索引
     * @param index 递归到哪一个电话号码
     * @param length  电话号码长度
     */
    private static void method_3(int[] total, String[] keyboard, int[] numbers, int[] answer, int index, int length) {
        if (index == length) {  //当深度到目标层时输出，并return
            for (int i = 0; i < length; i++) {
                System.out.print(keyboard[numbers[i]].charAt(answer[i]));
            }
            System.out.println();
            return;
        }
        for ( answer[index] = 0; answer[index] < total[numbers[index]]; answer[index]++) {  //方向
            method_3(total, keyboard, numbers, answer, index+1, length);    //每一个方向向下走， 深搜索
        }
    }

    private static void method_2(String[] keyboard, int[] total, int[] numbers, int[] answer) {
        int len = numbers.length;
        while (true) {
            for (int i = 0; i < len; i++) {
                System.out.print(keyboard[numbers[i]].charAt(answer[i]));
            }
            System.out.println();
            int k = len-1;
            while (k>=0) {
                if (answer[k] < total[numbers[k]]-1) {
                    answer[k]++;    //当前号码对应字母索引++，再从最后一个开始
                    break;
                }else {
                    answer[k] = 0;
                    k--;
                }
            }
            if (k<0) {
                break;
            }
        }
    }

    /**
     * 
     * @param keyboard 键盘数组：索引下标为号码， keyboard[i]表示号码i可以表示的字母串
     * @param total    total[i]:表示号码i可以表示的字符串长度，如“ABC”长度为3
     * @param numbers  电话号码数组
     * @param answer   answer[i]代表第i个号码代表哪个字母（索引）
     */
    private static void method_1(String[] keyboard, int[] total, int[] numbers, int[] answer) {
        for (answer[0] = 0; answer[0] < total[numbers[0]]; answer[0]++) {
            for ( answer[1] = 0; answer[1] < total[numbers[1]]; answer[1]++) {
                for ( answer[2] = 0; answer[2] < total[numbers[2]]; answer[2]++) {
                    for (int i = 0; i < 3; i++) {
                        System.out.print(keyboard[numbers[i]].charAt(answer[i]));
                    }
                    System.out.println();
                }               
            }
        }
        
    }
}