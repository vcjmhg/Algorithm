package tree;

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
}
