package stack;

import java.util.Stack;

/** 逆波兰表达式求值 */
public class LeetCode150 {
  public static void main(String[] args) {
    String[] tokens = {"10"};
    int reslut = new LeetCode150().evalRPN(tokens);
    System.out.println("reult = "+reslut);
  }

  public int evalRPN(String[] tokens) {
    // border situation judge
    if (tokens == null || ("").equals(tokens)) {
      return 0;
    }
    if (tokens.length == 1) {
      return new Integer(tokens[0]);
    }
    // put string and operator into stack
    Stack<String> stack = new Stack<>();
    int result = 0;
    for (String token : tokens) {
      if (isOperator(token)) {
        int nextVal = new Integer(stack.pop());
        int preVal = new Integer(stack.pop());
        result = operator(preVal,nextVal,token);
        stack.push(Integer.toString(result));
      } else {
        stack.push(token);
      }
    }
    return result;
  }
  
  private int operator(int preVal, int nextVal, String token) {
    if ("+".equals(token)){
      return preVal + nextVal;
    }else if ("-".equals(token)){
      return preVal - nextVal;
    }else if ("*".equals(token)){
      return preVal * nextVal;
    }else if ("/".equals(token)){
      return preVal / nextVal;
    }else {
      return 0;
    }
  }

  private boolean isOperator(String token) {
    if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
      return true;
    } else {
      return false;
    }
  }
}
