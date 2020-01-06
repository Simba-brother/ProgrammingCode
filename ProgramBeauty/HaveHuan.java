class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class HaveHuan {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        haveHuan(node);
    }

    private static boolean haveHuan(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}