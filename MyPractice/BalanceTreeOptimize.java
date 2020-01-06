class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
    
}
public class BalanceTreeOptimize {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node8.left = node9;
        boolean res = getAnswer(node1);
        System.out.println(res);
    }

    private static boolean getAnswer(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHigh = getTreeHigh(root.left);
        int rightHigh = getTreeHigh(root.right);
        if (leftHigh == -1 || rightHigh == -1) {
            return false;           
        }
        if (Math.abs(leftHigh - rightHigh) > 1) {
            return false;
        }
        return true;
    }

    private static int getTreeHigh(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHigh = getTreeHigh(node.left);
        int rightHigh = getTreeHigh(node.right);
        if (leftHigh == -1 || rightHigh == -1) {
            return -1;
        }
        if (Math.abs(rightHigh - leftHigh) > 1) {
            return -1;
        }
        return Math.max(leftHigh, rightHigh) +1;
    }
}