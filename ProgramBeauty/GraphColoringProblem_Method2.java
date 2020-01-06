import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class GraphColoringProblem_Method2 {
    static int maxColors  =0;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        N = sc.nextInt();   //会的数量
        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int begin = random.nextInt(10)+1;
            int end = begin + (random.nextInt(10)+1);
            list.add(new Meeting(begin, end));
        }
        getMinClassRoomNum(list);
    }

    public static void getMinClassRoomNum(List<Meeting> list) {
        boolean[] isForbidden = new boolean[N];
        int[] colors = new int[N]; // color[i]: 第i个会议涂的颜色
        for (int i = 0; i < N; i++) {   //遍历会议下标 ->i
            for (int k = 0; k < maxColors; k++) {   // 遍历现如今所有的色彩 ->k
                isForbidden[k] = false;     // k 颜色是可以用的
            }
            for (int j = 0; j < i; j++) {   // 遍历i会议的前的会议 ——j
                if (overlap(list.get(i), list.get(j))) {
                    isForbidden[color[j]] = true;
                }
            }
            for (int k = 0; k < maxColors; k++) {
                if (isForbidden[k] == false) {   //如果k颜色可以用
                    break;
                }
            }
            if ( k < maxColors) {
                colors[i]  = k;
            }else {
                maxColors++;
            }
        }
    }
    static class Meeting implements Comparable<Meetiong> {
        int begin;
        int end;

        /**
         * @param begin
         * @param end
         */

        public Meeting(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */

        @Override
        public String toString() {
            return "Meeting [begin=" + begin + ", end=" + end + "]";
        }
        
        @Override
        public int compare(Meeting o) {
            return this.begin > o.begin ? 1 : -1;
        }
    }
}