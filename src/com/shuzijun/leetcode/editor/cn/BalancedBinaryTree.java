// Given a binary tree, determine if it is height-balanced.
//
// For this problem, a height-balanced binary tree is defined as:
//
//
// a binary tree in which the left and right subtrees of every node differ in he
// ight by no more than 1.
//
//
//
// Example 1:
//
//
// Input: root = [3,9,20,null,null,15,7]
// Output: true
//
//
// Example 2:
//
//
// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
//
//
// Example 3:
//
//
// Input: root = []
// Output: true
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索
// 👍 509 👎 0

package com.shuzijun.leetcode.editor.cn;

import tree.TreeNode;

public class BalancedBinaryTree {
  public static void main(String[] args) {
    Solution solution = new BalancedBinaryTree().new Solution();
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;

    System.out.println(solution.isBalanced(root));
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
   * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
   */
  class Solution {
    public boolean isBalanced(TreeNode root) {
      return getHeight(root) >= 0;
    }

    private int getHeight(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int leftHeight = getHeight(root.left);
      if (leftHeight < 0) {
        return -1;
      }
      int rightHeight = getHeight(root.right);
      if (rightHeight < 0) {
        return -1;
      }
      if (Math.abs(leftHeight - rightHeight) > 1) {
        return -1;
      }
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
