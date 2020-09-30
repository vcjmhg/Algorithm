package stack;

import java.util.Arrays;

/**
 * 设计一个支持push、pop、top以及getMin操作的栈
 */
public class LeetCode155 {
  public static void main(String[] args) {
    MinStack stack = new MinStack();
    for (int i = 0; i <= 5; i++){
        stack.push(i);
    }
    System.out.println("top: " + stack.top());
    System.out.println("min "+ stack.getMin());
    stack.pop();
    System.out.println("new top :" + stack.top());
    
    for (int i = 0; i <=10; i++){
        stack.push(i);
    }
    System.out.println("top :" + stack.top());
  }
}
class MinStack {
    private int capisity = 5;
    private int vals[];
    //栈当前的访问指针
    private int current;
    /** initialize your data structure here. */
    public MinStack() {
        current = -1;
        vals = new int[capisity];
    }

    public void push(int x) {
        //如果入栈后超过容量，进行扩容操作
        if (current+1 >= capisity){
            increaseCapistiy();
        }
        vals[ ++current] = x;
    }
    //容量扩充
    private void increaseCapistiy(){
        int newCapisity = capisity *2 +1;
        int [] newVals = Arrays.copyOf(vals , newCapisity);
        vals = newVals;
        capisity = newCapisity;
    }

    public void pop() {
        if (current < 0) {
            return;
        }else {
            current --;
        }
    }

    public int top() {
        //对于0个元素的情况进行处理
        //if(current < 0) {}
        return vals[current];
    }

    public int getMin() {
        //对于0个元素的情况处理
//        if (current < 0){}
        int min = vals[0];
        for (int i = 0; i<= current; i++){
            if (vals[i] < min){
                min = vals[i];
            }
        }
        return min;
    }
}
