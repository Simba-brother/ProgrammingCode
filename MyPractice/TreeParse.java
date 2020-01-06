
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreeParse {
    public static void main(String[] args) {    
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println(parseTree(node1));
    }

    private static String parseTree(TreeNode node) {
        if (node == null) {
            return  "";
        }
        String leftStr = parseTree(node.left);
        String rightStr = parseTree(node.right);
        return node.val + "{"+leftStr+rightStr+"}";
    }
}