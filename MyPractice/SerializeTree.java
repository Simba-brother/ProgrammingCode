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
public class SerializeTree {
    static int preIndex = -1; //用作前序列化的遍历索引
    //static int layIndex = -1;
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 3, 5, 6};
        int[] inOrder = {4, 2, 1, 5, 3 ,6};
        TreeNode root = buildTree(preOrder, inOrder);
        System.out.println("树的preOrder为：");
        printTree(root);
        System.out.println();
        String preOrderSerialString = preSerializeTree(root);
        System.out.println("前序序列化串为：");
        System.out.println(preOrderSerialString);
        TreeNode treeNode = desPreSerializeTree(preOrderSerialString);
        System.out.println("将前序序列化进行反序列化：");
        printTree(treeNode);
        String layerSerialString =  layerSerializeTree(treeNode);
        System.out.println("层次序列化串为：");
        System.out.println(layerSerialString);
        System.out.println("将层次序列化进行反序列化：");
        TreeNode treeNode_layer = desLayerSerializeTree(layerSerialString);
        printTree(treeNode_layer);
    }

    private static TreeNode desLayerSerializeTree(String layerSerialString) {
        String[] values = layerSerialString.split("!");
        if (values == null || values.length == 0) {
            return null;
        }
        return desLayerSerializeTree_help(values);
    }

    private static TreeNode desLayerSerializeTree_help(String[] values) {
        int layIndex = 0;
        TreeNode root = generNodeByString(values[layIndex++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = generNodeByString(values[layIndex++]);
            node.right = generNodeByString(values[layIndex++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    private static TreeNode generNodeByString(String str) {
        if (str.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(str));
    }

    private static String layerSerializeTree(TreeNode treeNode) {
        if (treeNode == null) {
            return "#!";
        }
        String res  = treeNode.val+"!";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            if (treeNode.left != null) {
                res += treeNode.left.val+"!";
                queue.offer(treeNode.left);
            }else {
                res += "#!";
            }
            if (treeNode.right != null) {
                res += treeNode.right.val+"!";
                queue.offer(treeNode.right);
            }else {
                res += "#!";
            }
        }
        return res;
    }

    private static TreeNode desPreSerializeTree(String preOrderSerialString) {
        String[] strs = preOrderSerialString.split("!");
        if (strs.length == 0 || strs == null) {
            return null;
        }else {
            return desPreSerializeTree_help(strs);
        }
    }

    private static TreeNode desPreSerializeTree_help(String[] strs) {
        TreeNode node = null;
        preIndex++;
        if (preIndex >= strs.length) {
            return null;
        }else {
            if (!strs[preIndex].equals("#")) {
                node = new TreeNode(Integer.parseInt(strs[preIndex]));
                node.left = desPreSerializeTree_help(strs);
                node.right = desPreSerializeTree_help(strs);
            }
        }
        return node;
    }

    private static String preSerializeTree(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helpPreSerializeTree(root, sb);
        return sb.toString();
    }

    private static void helpPreSerializeTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#!");
        }else {
            sb.append(root.val+"!");
            helpPreSerializeTree(root.left, sb);
            helpPreSerializeTree(root.right, sb);
        }
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    private static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;   //树中总共有多少个节点
        TreeNode root = new TreeNode(preOrder[0]);
        int leftLength = 0;  //左子树节点个数
        while (leftLength < n && inOrder[leftLength] != preOrder[0]) {  //在中序中寻找前序[0]也就是根
            leftLength++;
        }
        int rightLength = n - leftLength -1;
        int[] left_pre = new int[leftLength];
        int[] right_pre = new int[rightLength];
        int[] left_in = new int[leftLength];
        int[] right_in = new int[rightLength];

        for (int i = 1; i <= leftLength; i++) {
            left_pre[i-1] = preOrder[i];
            left_in[i-1] = inOrder[i-1];
        }

        for (int i = 0; i < rightLength; i++) {
            right_pre[i] = preOrder[i+leftLength+1];
            right_in[i] = inOrder[leftLength+1+i];
        }

        if (leftLength > 0) {
            root.left =  buildTree(left_pre, left_in);
        }
        if (rightLength > 0) {
            root.right = buildTree(right_pre, right_in);
        }
        return root;
    }
}