package stack;

import java.util.Stack;

/**
 * 通过两个栈来进行解决
 */
public class LeetCode155_2 {
  public static void main(String[] args) {
      MinStack stack = new MinStack();
      stack.push(-2);
      stack.push(0);
      stack.push(-3);
      System.out.println("min" + stack.getMin());
      stack.pop();
      System.out.println("top:" + stack.top());
      System.out.println("min:"+stack.getMin());
  }
    static class MinStack {
        Stack<Long> stack;
        Stack<Long> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.empty()) {
                minStack.push(new Long(x));
            }else if (x < minStack.peek()) {
                minStack.push(new Long(x));
            }
            stack.push(new Long(x));
        }

        public void pop() {
            //此处不应该使用等号，因为两者都是Long类型的对俩，而不是long
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek().intValue();
        }

        public int getMin() {
            return minStack.peek().intValue();
        }
    }
}
