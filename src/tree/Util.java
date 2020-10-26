package tree;

import java.util.Stack;

public class Util {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;
    new Util().postOrderTraverse(root);
  }

  public void tranverse(TreeNode root) {
    // 边界判断
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        System.out.println(current.val);
        stack.push(current);
        current = current.left;
      } else {
        current = stack.pop();
//        System.out.println(current.val);
        current = current.right;
      }
    }
  }
  //使用双栈来实现后序遍历
  public void postOrderTraverse(TreeNode root){
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> res = new Stack<>();
    TreeNode cur = root;
    while (cur!=null || !stack.isEmpty()) {
      if (cur!=null){
        stack.push(cur);
        res.push(cur.val);
        cur = cur.right; //修改处
      }else{
        cur = stack.pop();
        cur = cur.left;  // 修改处
      }
    }
    while (!res.isEmpty()){
      System.out.println(res.pop());
    }
  }
}
