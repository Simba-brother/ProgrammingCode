import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.io.InputStreamReader;
/**
 * SortStackByStack
 */
public class SortStackByStack {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            stack.push(Integer.parseInt(data[i]));
        }
        sortByStack(stack);
        for (Integer var : stack) {
            System.out.print(var+" ");
        }
        //System.out.println(stack);
    }

    private static void sortByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}