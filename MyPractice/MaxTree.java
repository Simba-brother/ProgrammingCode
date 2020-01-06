import java.util.HashMap;
import java.util.Stack;

/**
 * MaxTree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class MaxTree {
    public static void main(String[] args) {
        int[] datas = {3, 4, 5, 1, 2};
        TreeNode head = getMaxTree(datas);
        printTree(head);
    }

    private static void printTree(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        printTree(head.left);
        printTree(head.right);
    }

    public static TreeNode getMaxTree(int[] datas) {
        TreeNode[] nodes = new TreeNode[datas.length];
        for (int i = 0; i < datas.length; i++) {
            nodes[i] = new TreeNode(datas[i]);
        }
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
        HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            TreeNode curNode = nodes[i];
            while (!stack.isEmpty() && stack.peek().val < curNode.val) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }

        for (int i = nodes.length-1; i >= 0; i--) {
            TreeNode curNode = nodes[i];
            while (!stack.isEmpty() && stack.peek().val<curNode.val ) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }

        TreeNode head = null;
        for (int i = 0; i < nodes.length; i++) {
            TreeNode curNode = nodes[i];
            TreeNode left_Father = lBigMap.get(curNode);
            TreeNode right_Father = rBigMap.get(curNode);
            if (left_Father == null && right_Father == null) {
                head = curNode;
            }else if (left_Father == null) {
                if (right_Father.left == null) {
                    right_Father.left = curNode;
                }else {
                    right_Father.right = curNode;
                }
            }else if(right_Father == null){
                if (left_Father.left == null) {
                    left_Father.left = curNode;
                }else {
                    left_Father.right = curNode;
                }
            }else {
                TreeNode parent = left_Father.val < right_Father.val ? left_Father : right_Father;
                if (parent.left == null) {
                    parent.left = curNode;
                }else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    private static void popStackSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
        TreeNode popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        }else {
            map.put(popNode, stack.peek());
        }

    }
}