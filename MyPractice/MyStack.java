import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        int[] datas = {3, 4, 5, 1, 2, 1};
        Stack<Integer> stack_data = new Stack<>();
        Stack<Integer> stack_min = new Stack<>();

        for (int i = 0; i < datas.length; i++) {
            push(stack_data, stack_min, datas[i]);
        }
        System.out.println("所有数据入栈以后的数据栈内容：");
        printStack(stack_data);
        System.out.println("\n所有数据入栈以后的最小栈内容：");
        printStack(stack_min);
        //push(stack_data, stack_min, number);
        int item = pop(stack_data, stack_min);
        System.out.println("\npop以后最小栈内容：");
        printStack(stack_min);  
        System.out.println("\npop以后数据栈内容：");
        printStack(stack_data);
        //int minValue = getMin(stack_min);
    }

    private static void printStack(Stack<Integer> stack_data) {
        if (stack_data.isEmpty()) {
            return;
        }
        for (Integer var : stack_data) {
            System.out.print(var+" ");
        }
    }

    private static int getMin(Stack<Integer> stack_min) {
        if (stack_min.isEmpty()) {
            throw new RuntimeException("最小栈已经空了");
        }
        return stack_min.pop();
    }

    private static int pop(Stack<Integer> stack_data, Stack<Integer> stack_min) {
        if (stack_data.isEmpty()) {
            throw new RuntimeException("数据栈已经空了");
        }
        int value = stack_data.pop();
        if (value == stack_min.peek()) {
            stack_min.pop();
        }
        return value;
    }

    private static void push(Stack<Integer> stack_data, Stack<Integer> stack_min, int number) {
        stack_data.push(number);
        if (stack_min.isEmpty()) {
            stack_min.push(number);
        }else {
            if (stack_min.peek() >= number) {
                stack_min.push(number);
            }
        }
    }
}