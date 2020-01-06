
import java.util.LinkedList;
import java.util.Queue;

/**
 * ZtransTree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class ZtransTree {

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
        LinkedList<LinkedList<Integer>> alist = ztransTree(node1);
        System.out.println(alist.size());
        for (LinkedList<Integer> list : alist) {    // 拿出每一层
            for (Integer var : list) {  
                System.out.print(var+" ");  //一层中的数据空格分割
            }
            System.out.println();   //层与层之间有空行
        }
    }

    private static LinkedList<LinkedList<Integer>> ztransTree(TreeNode pRoot) {
        LinkedList<LinkedList<Integer>> alist = new LinkedList<>();
        if (pRoot == null) {
            return alist;
        }
        
        Queue<TreeNode> queue1 = new LinkedList<>();    //层1
        Queue<TreeNode> queue2 = new LinkedList<>();    //层2
        queue1.offer(pRoot);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                LinkedList<Integer> list1= new LinkedList<>();  //准备用来存该层

                while (!queue1.isEmpty()) {     //遍历这一层的节点, 往list1中添加， 同时给另外的层队列入队
                    TreeNode temp = queue1.poll();
                    list1.add(temp.val);
                    if (temp.left != null) {
                        queue2.offer(temp.left); //先左
                    }
                    if (temp.right != null) {   //后右
                        queue2.offer(temp.right);
                    }
                }
                alist.add(list1);   //把这一层添加到结果集合中
            }else {
                LinkedList<Integer> list2= new LinkedList<>();  //准备用来存该层

                while (!queue2.isEmpty()) {     //遍历这一层的节点, 往list1中添加， 同时给另外的层队列入队
                    TreeNode temp = queue2.poll();
                    list2.add(temp.val);
                    if (temp.right != null) {
                        queue1.offer(temp.right);   //先右
                    }
                    if (temp.left != null) {
                        queue1.offer(temp.left);    //后左
                    }
                }
                alist.add(list2);   //把这一层添加到结果集合中
            }
        }
        return alist;
    }
}