public class TreeOfMaxDistance {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int maxLeftDistance;    //左子树根到叶子节点最大距离
        int maxRightDistance;   //右子树根到叶子节点最大距离
        public TreeNode(int val) {
            this.val = val;
        }
    }
    static int res =0; //通用全局变量
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;

        maxDIstance(node1);
        System.out.println(res);
    }
    public static void maxDIstance(TreeNode node) {
        if (node == null) {
            return;     //点为空啥也不干；
        }
        //节点不为空
        if (node.left != null) {    //如果该节点左孩子不空, 递归左孩子
            maxDIstance(node.left); 
        }else {     //如果该节点没有左孩子， 该节点的左子树根到叶子节点的距离设置为0
            node.maxLeftDistance = 0;
        }

        if (node.right != null) {
            maxDIstance(node.right);           
        }else {
            node.maxRightDistance = 0;
        }

        if (node.left != null) {
            node.maxLeftDistance = Math.max(node.left.maxLeftDistance, node.left.maxRightDistance)+1;
        }
        if (node.right != null) {
            node.maxRightDistance = Math.max(node.right.maxLeftDistance, node.right.maxRightDistance)+1;
        }
        res = Math.max(node.maxLeftDistance+node.maxRightDistance, res);
    }
}