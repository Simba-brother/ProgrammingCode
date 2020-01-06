/**
 * PreOrderTree
 */
class TreeNode {
    int val; 
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class PreOrderTree {
    static int index =-1;
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
        String preOrderSeriali = getPreOrderSerial(node1);
        System.out.println(preOrderSeriali);
        String[] preOrderSeriali_values = preOrderSeriali.split("!");
        TreeNode root =  desPreOrderSerial(preOrderSeriali_values);
        printTree(root);
;    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }

    private static TreeNode desPreOrderSerial(String[] preOrderSeriali_values) {
        if (preOrderSeriali_values == null || preOrderSeriali_values.length == 0) {
            return null;
        }
        index++;
        if (preOrderSeriali_values[index].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(preOrderSeriali_values[index]));
        root.left = desPreOrderSerial(preOrderSeriali_values);
        root.right = desPreOrderSerial(preOrderSeriali_values);
        return root;
    }

    private static String getPreOrderSerial(TreeNode node1) {
        StringBuilder sb = new StringBuilder();
        getPreOrderSerial_help(node1, sb);
        return sb.toString();
    }

    private static void getPreOrderSerial_help(TreeNode node, StringBuilder sb) {
        if (node ==null) {
            sb.append("#!");
        }else {
            sb.append(node.val+"!");
            getPreOrderSerial_help(node.left, sb);
            getPreOrderSerial_help(node.right, sb);
        }
    }
}