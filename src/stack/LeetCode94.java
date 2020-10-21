package stack;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 堆栈问题使用 */
public class LeetCode94 {
  public static void main(String[] args) {
    TreeNode node = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    node.left = node1;
    node.right = node2;
    List<Integer> result = new LeetCode94().inorderTravsersalByReverse(node);
    System.out.println("result is :" + result);
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    // 使用堆栈来进行中旬遍历
    List<Integer> reslut = new ArrayList<>();
    Stack<TreeNode> stack = new Stack();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode node = stack.pop();
        reslut.add(node.val);
        root = node.right;
      }
    }
    return reslut;
  }

  public List<Integer> inorderTravsersalByReverse(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    return result;
  }

  private void inorder(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    inorder(root.left, result);
    result.add(root.val);
    inorder(root.right, result);
  }
}
