class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    /**
     * @param val
     */

    public TreeNode(int val) {
        this.val = val;
    }
    
}
public class TreeHigh {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        // int high =  getHigh(root);
        // System.out.println(high);

        System.out.println(getHigh_2(root));  
    }


    private static int getHigh_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHigh_2(root.left)+1; //得到下一个节点的函数结果的基础上再把自己加上
        int rightH = getHigh_2(root.right)+1;
        return Math.max(leftH, rightH);
    }

    private static int getHigh(TreeNode root) {
        if (root == null) {     //出口
            return 0;
        }
        return Math.max(getHigh(root.left), getHigh(root.right)) + 1;
    };


}