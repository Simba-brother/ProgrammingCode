class ListNode {
    int val;
    ListNode next;

    /**
     * @param val
     * @param next
     */

    public ListNode(int val) {
        this.val = val;
    }
    
}
public class LinkedListInterSect {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        isInterSect(list1, list2);
        ListNode interSect = interSect(list1, list2);
    }

    private static ListNode interSect(ListNode list1, ListNode list2) {
        int len1=0;
        int len2 = 0;
        ListNode p = list1;
        ListNode q = list2;
        int dif  =0;
        while (p!=null) {
            len1++;
            p = p.next;
        }
        while (q!=null) {
            len2++;
            q =q.next;
        }
        if (len1 > len2) {
            dif = len1- len2;
            while (dif > 0) {
                p = p.next;
                dif--;
            }
        }else {
            dif = len2- len1;
            while (dif >  0) {
                p = p.next;
                dif--;
            } 
        }
        while (p!=q && p!=null && q!=null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    private static boolean isInterSect(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        while (p.next != null) {
            p = p.next;
        }
        //此时p是list1的最后一个
        while (q.next != null) {
            q = q.next;
        }
        //此时q是list2的最后一个
        if (p == q) {
            return true;
        }else {
            return false;
        }
    }


}