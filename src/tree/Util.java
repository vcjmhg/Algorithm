package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

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
    new Util().preOrder(root);
  }

  public void preOrder(TreeNode root) {
    // 边界判断
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    TreeNode cur = root;
    while (!stack.isEmpty() || cur != null) {
      if (cur != null) {
//        System.out.println(cur.val);
        stack.add(cur);
        cur = cur.left;
      } else {
        cur = stack.pop();
        System.out.println(cur.val);
        cur = cur.right;
      }
    }
  }
}

