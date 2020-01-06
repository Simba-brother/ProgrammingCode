/**
 * ThreadedTree
 */
//https://blog.csdn.net/UncleMing5371/article/details/54176252
class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;
    boolean left_tag;  //如果为true表示是线索
    boolean right_tag;
    public TreeNode(String val) {
        this.val = val;
    }
}
public class ThreadedTree {
    static TreeNode pre = null;
    public static void main(String[] args) {
        String[] data = {"A", "B", "C", "D", "E", "F", "G", "H"};
        TreeNode root = createTree(data, 0);
        TreeNode threadedRoot = inOrderThread(root);
        inOrderTraversThreadedTree(root);
        TreeNode preOrder_threadedRoot = preOrderThread(root);
        preOrderTraversThreadedTree(root);
        
    }

    private static TreeNode preOrderThread(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            node.left_tag = true;
            node.left = pre;
        }
        if (pre != null || pre.right == null) {
            pre.right_tag = true;
            pre.right = node;
        }
        if (node.left_tag == false) {
            preOrderThread(node.left);
        }
        if (node.right_tag == false) {
            preOrderThread(node.right);
        }
        return node;
    }

    private static void preOrderTraversThreadedTree(TreeNode node) {
        while (node != null) {
            while (node.left_tag == false) {
                System.out.print(node.val+",");
                node = node.left;
            }
            System.out.print(node.val+",");
            node = node.right;
        }
    }

    private static void inOrderTraversThreadedTree(TreeNode node) {
        //找到了最左的孩子了
        while (node != null && node.left_tag == false) {
            node = node.left;
        }
        while (node != null) {
            System.out.print(node.val+",");
            //找后继
            if (node.right_tag == true) {
                node = node.right;
            }else {
                node = node.right;
                while (node != null && node.left_tag == false) {
                    node = node.left;
                }
            }
        }
    }

    private static TreeNode inOrderThread(TreeNode node) {
        if (node == null) {
            return null;
        }
        inOrderThread(node.left);
        if (node.left == null) {
            node.left_tag = true;  //线索化前驱
            node.left = pre;
        }
        if (pre.right == null) {
            pre.right_tag = true; //线索化后继
            pre.right = node;
        }
        pre = node;
        inOrderThread(node.right);
        return node;
    }

    private static TreeNode createTree(String[] data, int index) {
        TreeNode node = null;
        if (index < data.length) {
            node = new TreeNode(data[index]);
            node.left  = createTree(data, index*2+1); 
            node.right = createTree(data, index*2+2);
        }
        return node;
    }
}