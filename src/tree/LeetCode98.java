package tree;

import java.util.Stack;

public class LeetCode98 {
  // 通过后续遍历来验证二叉搜索树
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }
  //    通过两个参数来传递左分支以及有分支的值
  private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    if (root == null) {
      return true;
    }
    if (min != null && root.val <= min.val) {
      return false;
    }
    if (max != null && root.val >= max.val) {
      return false;
    }
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }

  /**
   * 借助中序遍历来进行验证，根据二叉搜索树的特点，在对二叉搜索树进行中序遍历时得到的结果一定是升序的
   * @param root
   * @return
   */
  public boolean isValidBST2(TreeNode root) {
    if (root == null) {
      return true;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (pre != null && root.val <= pre.val) {
        return false;
      }
      pre = root;
      root = root.right;
    }
    return true;
  }
}
