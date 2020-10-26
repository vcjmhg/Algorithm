package tree;

public class LeetCode124 {
  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    helper(root);
    return max;
  }

  private int helper(TreeNode root) {
    // border judge
    if (root == null) {
      return 0;
    }
    int leftVal = Math.max(helper(root.left), 0);
    int rightVal = Math.max(helper(root.right), 0);
    // 比较max的值与根节点、左子树、右子树之和的最大值，使用max函数很巧妙
    max = Math.max(max, root.val + leftVal + rightVal);
//    返回的时候都是从上一个节点返回的，在返回值的时候只返回其中的一个最大分支
    return root.val + Math.max(leftVal, rightVal);
  }
}
