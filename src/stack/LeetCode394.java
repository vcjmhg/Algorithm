package stack;

import java.util.Stack;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class LeetCode394 {
  public static void main(String[] args) {
    String result = new LeetCode394().decodeString("a2[a]");
    System.out.println(result);
  }

  int ptr;
  // 借助与堆栈解决字符解码问题s
  public String decodeString(String s) {
    // border case
    if (s == null || "".equals(s)) {
      return s;
    }
    Stack<String> stack = new Stack<>();
    for (ptr = 0; ptr < s.length(); ptr++) {
      char ch = s.charAt(ptr);
      if (isDigit(ch)) {
        // if ch is digital , get this digital and put it into stack
        String digitalStr = getDigital(s);
        
        stack.push(digitalStr);
      } else if (isLetter(ch) || ch == '[') {
        // if ch is letter  , put ch into stack.
        stack.push(Character.toString(ch));
      } else {
        // if ch is ']',pop stack util ch is '['
        // resolve the case that tokens contains "[]"
        if (stack.peek().equals("[")) {
          //pop "["
          stack.pop();
          // if the character before "[" is digital,pop this digital
          if (isDigit(stack.peek().charAt(0))) {
            stack.pop();
          }
        }else {
          StringBuffer sb = new StringBuffer();
          String sch = stack.pop();
          while (!"[".equals(sch)) {
            sb.append(sch);
            sch = stack.pop();
          }
          // parsing tokens after get the digital
          int digital = Integer.parseInt(stack.pop());
          parseTokens(sb, digital);
          // put the string which has been parsed into stack
          stack.push(sb.toString());
        }
      }
    }
    StringBuffer result = new StringBuffer();
    while (!stack.isEmpty()) {
     result.append(stack.pop()); 
    }
    return result.reverse().toString();
  }

  private void parseTokens(StringBuffer sb, int digital) {
    String str = sb.toString();
    for (int i = 1; i < digital; i++) {
      sb.append(str);
    }
  }

  private String getDigital(String s) {
    StringBuffer sb = new StringBuffer();
    while (isDigit(s.charAt(ptr))) {
      sb.append(s.charAt(ptr));
      ptr++;
    }
    ptr --;
    return sb.toString();
  }
}
