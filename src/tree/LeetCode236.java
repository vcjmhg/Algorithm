package tree;

public class LeetCode236 {
  /**
   * 使用后续遍历寻找公共父节点
   * 基本思路：
   * 
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    // left equals null and left equals null
    return root;
  }
}
