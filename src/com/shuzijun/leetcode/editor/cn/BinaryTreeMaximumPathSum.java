// Given a non-empty binary tree, find the maximum path sum.
//
// For this problem, a path is defined as any node sequence from some starting n
// ode to any node in the tree along the parent-child connections. The path must co
// ntain at least one node and does not need to go through the root.
//
//
// Example 1:
//
//
// Input: root = [1,2,3]
// Output: 6
//
//
// Example 2:
//
//
// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 3 * 104].
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索
// 👍 757 👎 0

package com.shuzijun.leetcode.editor.cn;

import tree.TreeNode;

public class BinaryTreeMaximumPathSum {
  public static void main(String[] args) {
    Solution solution = new BinaryTreeMaximumPathSum().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
   * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
   */
  class Solution {
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
      // update max
      max = Math.max(max, root.val + leftVal + rightVal);
      return root.val + Math.max(leftVal, rightVal);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
