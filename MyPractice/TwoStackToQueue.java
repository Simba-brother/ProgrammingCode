import java.util.Stack;

/**
 * TwoStackToQueue
 */
public class TwoStackToQueue {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 4, 5};
        for (int i = 0; i < datas.length; i++) {
            add(datas[i]);
        }
        int peekItem = peek();
        System.out.println("队首:"+peekItem);
        int pollItem = poll();
        System.out.println("弹出后队首："+peek());
        //add(data[0]);       
        //int item = peek();
        //int item = poll();
    }

    private static int poll() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列已经空了");
        }else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    private static int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列已经空了");
        }else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    private static void add(int num) {
        stack1.push(num);
    }
}