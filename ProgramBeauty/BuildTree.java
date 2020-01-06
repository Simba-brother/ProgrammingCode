import java.util.Scanner;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    /**
     * @param val
     */

    public TreeNode(char val) {
        this.val = val;
    }
    
}
public class BuildTree {
    static int index = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String preString = sc.next();
            String inString = sc.next();
            char[] pre = preString.toCharArray();
            char[] in = preString.toCharArray();
            TreeNode root = reBuild(pre, in);
            printTree(root);
            String strOfTree = serialize(root);
            TreeNode treeRoot = deserialize(strOfTree);
            
        }
    }

    private static TreeNode deserialize(String strOfTree) {
        String[] arr = strOfTree.split("!");
        StringBuilder sb = new StringBuilder();
        for (String var : arr) {
            sb.append(var);
        }
        char[] chars = sb.toString().toCharArray();
        TreeNode node = null;
        index++;
        if (chars[index] != '#') {
            node = new TreeNode(chars[index]);
            node.left = deserialize(strOfTree);
            node.right = deserialize(strOfTree);
        }
        return node;
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preSerialize(root, sb);
        return sb.toString();
    }

    private static void preSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        sb.append(root.val+"!");
        preSerialize(root.left, sb);
        preSerialize(root.right, sb);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    private static TreeNode reBuild(char[] pre, char[] in) {
        int n = pre.length;  // 该树共有多少个节点
        TreeNode root = new TreeNode(pre[0]);
        int leftLength = 0;
        while (leftLength<n && in[leftLength] != pre[0]) {
            leftLength++;
        }
        int rightLength = n - leftLength -1;
        char[] left_pre = new char[leftLength];    //存前序列中的左串
        char[] left_in = new char[leftLength]; //存中序列中的左串
        char[] right_pre = new char[rightLength];    //存前序列中的右串
        char[] right_in = new char[rightLength]; //存中序列中的右串

        for (int i = 1; i <= leftLength; i++) {
            left_pre[i-1] = pre[i];
            left_in[i-1] = in[i-1];
        }
        for (int i = 0; i < rightLength; i++) {
            right_pre[i] = pre[i+leftLength+1];
            right_in[i] = in[leftLength+1+i];
        }
        if (leftLength > 0) {
            root.left = reBuild(left_pre, left_in);    
        }
        if (rightLength > 0) {
            root.right = reBuild(right_pre, right_in);
        }
        return root;
    }
}