package tree;

public class LeetCode701 {
  //使用后续遍历的方式来插入二叉搜索树的新节点
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (val > root.val) {
      root.right = insertIntoBST(root.right, val);
    }
    if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    }
    return root;
  }
}
