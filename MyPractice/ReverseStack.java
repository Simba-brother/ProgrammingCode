import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * ReverseStack
 */
public class ReverseStack {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < data.length; i++) {
            stack.push(Integer.parseInt(data[i]));
        }
        // int last = getAndRemoveLastElement(stack);
        reverse(stack);
        for (Integer var : stack) {
            System.out.print(var+" ");
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }else {
            int temp = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(temp);
        }
    }

    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();  // 递归每一层都会将栈顶元素弹出并另存 到 局部变量result
        if (stack.isEmpty()) {
            return result;            
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result); // 从倒数第二层开始往回
            return last;
        }
    }
}