package Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1);
        // ArrayList<ArrayList<Integer>> ans = layerTrans(root);
        // ArrayList<Integer> prelist = preOrderTraveral(root);
        // ArrayList<Integer> inList = inOrderTraveral(root);
        // ArrayList<Integer> postOrderList = postOrderTraveral(root);
        // ArrayList<ArrayList<Integer>> layerTrans = layerTrans(root);
    }
    /**
     * 后序遍历二叉树（递归）
     * @param root 要遍历二叉树的根结点
     * @return
     */
    public static ArrayList<Integer> postOrderTraveral(TreeNode root) {  
        ArrayList<Integer> list = new ArrayList<>();  //存最终遍历结果的
        if (root == null) {
            return list;
        }
        helpPostOrderTravral(root, list);
        return list;
    }

    public static void helpPostOrderTravral(TreeNode root, ArrayList<Integer> list) {
        if (root.left != null) {     //如果有左孩子，继续递归左孩子
            helpPostOrderTravral(root.left, list);
        }
        if (root.right !=  null) {  //如果有右孩子， 继续递归右孩子
            helpPostOrderTravral(root.right,list);
        }
        list.add(root.val); //把自己加到结果集中
    }
    /**
     * 中序遍历二叉树（递归）
     * @param root  //树根
     * @return
     */
    public static ArrayList<Integer> inOrderTraveral(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>(); //结果集合
        if (root == null) {
            return list;
        }
        helperInOrder(root, list);
        return list;
    }

    public static void helperInOrder(TreeNode root, ArrayList<Integer> list) {
        if (root.left != null) {  //有左孩子，递归左孩子
            helperInOrder(root.left, list);
        }
        list.add(root.val);  //自己加入结果集
        if (root.right != null) { //有右孩子， 递归右孩子
            helperInOrder(root.right, list);  
        }
    }
    /**
     * 前序遍历二叉树（递归）
     * @param root //树根
     * @return
     */
    public static ArrayList<Integer> preOrderTraveral(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();  //结果集
        if (root == null) {
            return list;
        }
        helperPreOrder(root, list);
        return list;
    }

    public static void helperPreOrder(TreeNode root,  ArrayList<Integer> list) {
        list.add(root.val); //自己加入结果集
        if (root.left != null) {  //有左孩子，递归左孩子
            helperPreOrder(root.left, list);
        }
        if (root.right != null) {  //if有右孩子，递归右孩子
            helperPreOrder(root.right, list);
        }
    }
    /**
     * 层次遍历二叉树 （非递归）
     * @param root  //树根
     * @return
     */
    public static ArrayList<ArrayList<Integer>> layerTrans(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helperLayerTrans(root, list);
        return list;
    }

    public static void helperLayerTrans(TreeNode root, ArrayList<ArrayList<Integer>> list) {
        Queue<TreeNode> queue = new LinkedList<>();
        int lay_count = 0;  //层数从0开始
        queue.add(root);    // 队列初始为 里面只有一个根
        queue.add(null);    //每一层行尾部标志
        list.add(new  ArrayList<Integer>()); //第0层的容器被添加到里面
        while (!queue.isEmpty()) {  //当 队列不空
            TreeNode temp = queue.poll();   //取头，另存
            if (temp != null) { //如果 这个东西不是空
                list.get(lay_count).add(temp.val); //把这个东西加入到当前层的容器中
                if (temp.left != null) {    //接着 ，这个东西有左孩子，左孩子入队
                    queue.add(temp.left);
                }
                if (temp.right != null) {   //这个孩子有右孩子，右孩子入队
                    queue.add(temp.right);
                }
            }else { //否则如果这个东西为空
                if (!queue.isEmpty()) { //如果队列还有元素
                    lay_count++;    //说明层数++
                    list.add(new ArrayList<Integer>()); //另一层的容器准备好
                    queue.add(null);  //这一层的结束标志
                }
            }
        }
    }
    /**
     * 前序遍历二叉树非递归  根左右
     */
    public static ArrayList<Integer> preOrderTransNoRecursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helpPreOrderTransNoRecursion(root, list);
        return list;
    }

    private static void helpPreOrderTransNoRecursion(TreeNode root, ArrayList<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);  //根入栈
        while (stack != null) { //当 栈不空
            TreeNode temp = stack.pop(); //弹栈
            list.add(temp.val);  //加入结果集
            if (root.right != null){    //右孩子 不为空就右孩子入栈。 根左右 所以右先入栈
                stack.push(root.right); 
            }
            if (root.left != null) {    //左孩子不空则左孩子入栈
                stack.push(root.left);
            }
        }
    }

    /**
     * 中序遍历二叉树非递归  //左根右
     * @param root //树根
     */
    public static  ArrayList<Integer> inOrderTransNoRecursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();  //结果集合
        if (root == null){
            return list;
        } 
        helpInOrderTransNoRecursion(root, list);
        return list;
    }

    private static void helpInOrderTransNoRecursion(TreeNode root, ArrayList<Integer> list) {
        HashMap<TreeNode, Integer> map = new HashMap<>();  //某个树节点是否被访问过
        Stack<TreeNode> stack = new Stack<>();  
        stack.push(root);
        while (!stack.isEmpty()) {  
            root = stack.peek(); // 看一下栈顶，另存 因为最左节点先加入结果集， 所以不pop
            //这个while会走到最下脚
            while(root.left!= null)  {  //当左孩子不空，如果左孩子还没有被访问过，一直往左走并且一直压栈。
                if (map.containsKey(root.left)){
                    break;
                }
                stack.push(root.left);
                root = root.left;
            }
            //此时栈顶是最左
            root = stack.pop();
            list.add(root.val);
            map.put(root, 1); //设置该节点被访问了
            if (root.right != null) {  //这个地方是if 如果最左含有右节点，压栈
                stack.push(root.right);
            }
        }
    }

    /**
     * 后序遍历二叉树非递归
     */
    public static ArrayList<Integer> postOrderTransNoRecursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helpPostOrderTransNoRecursion(root, list);
        return list;
    }

    private static void helpPostOrderTransNoRecursion(TreeNode root, ArrayList<Integer> list) {
        HashMap<TreeNode, Integer> map = new HashMap<>();  //节点是否被访问
        Stack<TreeNode> stack  = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.peek();  // 看一下顶
            if (root.left == null || root.right == null) {  //左右都空， pop 加入结果集
                root = stack.pop();
                map.put(root, 1);
                list.add(root.val);
            }else if((root.left != null && root.right != null && map.containsKey(root.left) && map.containsKey(root.right)) || (root.left!=null && root.right == null && map.containsKey(root.left)) || (root.left == null && root.right != null&& map.containsKey(root.right))) {
                //有孩子但是孩子都被访问过了 同样加入结果集
                root = stack.pop();
                map.put(root, 1); 
                list.add(root.val);
            }else {
                while(root.left!=null) {  //和中序一样，一直往左走
                    if (map.containsKey(root.left)){
                        break;
                    }
                    stack.push(root.left);
                    root = root.left;
                }
                //此时root已经最左了
                if (root.right != null) {
                    stack.push(root.right);
                } 
            }
        }
    }

    public static ArrayList<Integer> preOrderTransNoRecursion_Simple(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helpReOrderTransNoRecursion_Simple(root, list);
        return list;
    }

    private static void helpReOrderTransNoRecursion_Simple(TreeNode root, ArrayList<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        // 此时root一定不为空，因为方法调过来的
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static ArrayList<Integer> inOrderTransNoRecursion_Simple(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helpInOrderTransNoRecursion_Simple(root,list);
        return list;
    }

    private static void helpInOrderTransNoRecursion_Simple(TreeNode root, ArrayList<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }

    public static ArrayList<Integer> postOrderNoRecursion_Simple(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helpPostOrderTransNoRecursion_Simple(root, list);
        return list;
    }

    private static void helpPostOrderTransNoRecursion_Simple(TreeNode root, ArrayList<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                list.add(0, root.val); 
                root = root.right; //左右根 ——》 右左根； list.add(0, )->list.add(1, ..)
            }else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 判断一棵树是否是平衡
     * @param root
     * @return
     */
    private static boolean isBalance(TreeNode root) {
        if (root == null) {
            return false;
        }
        int leftHigh =heigh(root.left);
        int rightHigh = heigh(root.right);
        if (Math.abs(leftHigh - rightHigh) > 1) {
            return false;
        }
        return true;
    }
    /**
     * 求树高 根节点树高为1
     * @param root
     * @return
     */
    private static int heigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heigh(root.left), heigh(root.right))+1;
    }
}