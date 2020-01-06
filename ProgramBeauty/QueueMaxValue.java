
public class QueueMaxValue {
    static class MyStack {
        final int MAXN = 10;   //栈容量
        private int stackTop;   //栈顶索引
        private int maxStackItemIndex;  //最大元素的索引
        private int[] stackItem = new int[MAXN];    //栈
        private int[] link2NextMaxItem = new int[MAXN]; //连接到下一个最大元素

        public MyStack() {
            stackTop = -1;  //栈顶初始化为-1
            maxStackItemIndex = -1; //最大元素索引初始化为-1；
        }
        
        public void push(int x) {
            stackTop++;
            if (stackTop > MAXN -1) {
                System.out.println("栈已经满了");
                return;
            }else {
                stackItem[stackTop] = x;    // 入栈了
                if (x > maxValue()) {
                    link2NextMaxItem[stackTop] = maxStackItemIndex;  //记录上一次最大的索引
                    maxStackItemIndex = stackTop;
                }else {
                    link2NextMaxItem[stackTop] = -1;
                }
            }
        }

        /**
         * 根据最大值的索引maxStackItemIndex返回出最大值
         * @return
         */
        private int maxValue() {
            if (maxStackItemIndex >= 0) {
                return stackItem[maxStackItemIndex];
            }
            return Integer.MIN_VALUE;
        }

        public int pop() {
            int ret;
            if (stackTop < 0) {
                System.out.println("栈已经空了，不能再pop了");
                throw new IndexOutOfBoundsException();
            }else {
                ret = stackItem[stackTop];
                if (stackTop == maxStackItemIndex) {
                    maxStackItemIndex = link2NextMaxItem[stackTop]; //maxStackItemIndex指向上次最大的索引
                }
                stackTop--;
            }
            return ret;
        }
    }
    public static void main(String[] args) {
        
    }
}