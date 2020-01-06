import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class SerializeTreeByLayer {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        String strOfByLayer = serializeByLayer(node1);
    }

    private static String serializeByLayer(TreeNode node) {
        if (node == null) {
            return "#!";
        }
        String res = node.val+"!";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
           node = queue.poll();
        }
        return res;
    }
}