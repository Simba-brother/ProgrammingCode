import java.util.ArrayList;
import java.util.Stack;

/**
 * noRecursionTraverTree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class noRecursionTraverTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        getAnswer(node1);
    }

    private static void getAnswer(TreeNode node) {
        if (node == null)  {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        help(node, list);  //node一定不为空
    }

    private static void help(TreeNode node, ArrayList<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                list.add(node.val);
                node = node.left;
            }else {
                node = stack.pop();
                node = node.right;
            }
        }
    }
}