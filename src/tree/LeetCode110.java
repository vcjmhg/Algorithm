package tree;

public class LeetCode110 {
  /**
   *  自顶向下进行递归
   * @param root
   * @return
   */
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (Math.abs(treeLength(root.left) - treeLength(root.right)) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  private int treeLength(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(treeLength(root.left), treeLength(root.right)) + 1;
  }
}
