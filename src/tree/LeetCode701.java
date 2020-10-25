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
  //模拟二叉搜索树手动插入过程来插入新的节点
  public TreeNode insertIntoBST2(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode pos = root;
    while (pos != null) {
      if (val < pos.val) {
        if (pos.left == null) {
          pos.left = new TreeNode(val);
          break;
        } else {
          pos = pos.left;
        }
      } else {
        if (pos.right == null) {
          pos.right = new TreeNode(val);
          break;
        } else {
          pos = pos.right;
        }
      }
    }
    return root;
  }
}
