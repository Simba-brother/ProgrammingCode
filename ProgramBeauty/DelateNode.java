class Node {
    int val;
    Node next;

    /**
     * @param val
     * @param next
     */

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    
}
public class DelateNode {
    
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node pCur = node3;
        delateNode(pCur);
        Node point = node1;
        while (point != null) {
            System.out.print(point.val+"->");
            point = point.next;
        }
    }

    private static void delateNode(Node pCur) {
        int tempVal = pCur.next.val;
        pCur.next = pCur.next.next;
        pCur.val = tempVal;
    }
}