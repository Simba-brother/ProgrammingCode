class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class TwoListSum {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1_1= new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        l1.next = l1_1;
        l1_1.next = l1_2;

        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        ListNode l2_3 = new ListNode(7);
        ListNode l2_4 = new ListNode(8);
        l2.next = l2_1;
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;
        
        ListNode dummy = addTwoNumbers(l1, l2);
        ListNode p = dummy;
        while (p!= null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        int sum = 0;
        int value = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            value = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(value);
            current.next = node;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            value = sum %10;
            carry = sum / 10;
            ListNode node = new ListNode(value);
            current.next = node;
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            value = sum %10;
            carry = sum / 10;
            ListNode node = new ListNode(value);
            current.next = node;
            current = current.next;
            l2 = l2.next;
        }
        if (carry>0) {
            ListNode node = new ListNode(carry);
            current.next = node;
            current = current.next;
            
        }
        return dummy.next;
    }
}