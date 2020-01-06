public class TreeOfMaxDistance2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    static class Result {
        public int maxDis;  // 以node为根的最大distance
        public int maxDep;  // 以node为根的树高度   单独一个节点树的高度为 0 ！！！
        public Result(int maxDis, int maxDep) {
            this.maxDis = maxDis;
            this.maxDep = maxDep;
        }
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;

        System.out.println(getMaxDistance(node1).maxDis);   
    }

    private static Result getMaxDistance(TreeNode node1) {
        if (node1 == null) {
            return new Result(0, -1);
        }
        Result leftResult = getMaxDistance(node1.left);
        Result rightResult = getMaxDistance(node1.right);
        int maxdis = Math.max(leftResult.maxDep+rightResult.maxDep+2, Math.max(leftResult.maxDis, rightResult.maxDis));
        return new Result(maxdis, Math.max(leftResult.maxDep, rightResult.maxDep)+1);
    }
}





