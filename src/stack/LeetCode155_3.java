package stack;

import java.util.Stack;

/**
 * 通过一个栈来解决最小栈问题
 */
public class LeetCode155_3 {
    public static void main(String[] args) {
    //
    }
    static class MinStack {
        Stack<Integer> stack;
        int min;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.empty()) {
                min = x;
            }
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (min == stack.pop()){
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
