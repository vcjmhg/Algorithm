package queue;

import java.util.Stack;

public class LeetCode232 {
    
}

// 使用两个栈，来实现一个简单的队列
class MyQueue {
  Stack<Integer> in, out;
  /** Initialize your data structure here. */
  public MyQueue() {
    in = new Stack<>();
    out = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    in.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
      int x = peek();
      out.pop();
      return x;
  }

  /** Get the front element. */
  public int peek() {
    int x;
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        x = in.pop();
        out.push(x);
      }
    }
    return out.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    if (in.isEmpty() && out.isEmpty()) {
      return true;
    }
    return false;
  }
}
