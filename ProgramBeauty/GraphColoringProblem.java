import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;



/**
 * 按照各个会议的结束事件从小到大排列
 * 遍历列表填充sameClassRoom列表
 * list.removeAll(sameClassRoom)
 * 
 */
public class GraphColoringProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        static class Meeting implements Comparable<Meeting>  {
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
            public int compare(Meeting o) {     //根据end从小到大
               return ( this.end > o.end ? 1:-1);
            }
        }

        ArrayList<Meeting> list = new ArrayList<>();
        Random rand = new Random();

        //填充list
        for (int i = 0; i < N; i++) {
            int begin = rand.nextInt(10)+1;
            int end = begin + (rand.nextInt(10)+1);
            Meeting meet = new Meeting(begin, end);
            list.add(meet);
        }
        smartManagment(list);

    }

    public static void smartManagment(ArrayList list) {
        if (list == null || list.size() < 2) {
            return;
        }
        Collection.sort(list);  //把会议安排按照会议的end进行排序
        ArrayList<ArrayList<Meeting>> outerList = new ArrayList<>();
        while (list.size() != 0) {
            int size = list.size();
            ArrayList<Meeting> sameClassRoom = new ArrayList<>();
            Meeting curMeet = list.get(0);
            //填充sameClassRoom列表
            for (int i = 1; i < size; i++) {
                if (list.get(i).begin >= curMeet.begin && list.get(i).begin <= curMeet.end) {
                    sameClassRoom.add(list.get(i));
                    curMeet = list.get(i);
                }
            }
            outerList.add(sameClassRoom);
            list.removeAll(sameClassRoom);
        }

        for(int i=0;i<outerList.size();i++){  
            printList(outerList.get(i));  
        } 
    }

    public static void printList(List<Meeting> list) {
        if(list==null||list.size()==0){  
            return;  
        }  
        for(int i=0,size=list.size();i<size;i++){  
            System.out.print(list.get(i));  
        }  
        System.out.println();  
    }
}