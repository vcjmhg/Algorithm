// Given a binary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// return its depth = 3.
// Related Topics 树 深度优先搜索
// 👍 727 👎 0

package com.shuzijun.leetcode.editor.cn;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
  public static void main(String[] args) {
    Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;
    int depth = solution.maxDepth(root);
    System.out.println(depth);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {
    public int maxDepth(TreeNode root) {
      // border judge
      if (root == null) {
        return 0;
      }
      int left = maxDepth(root.left);
      int right = maxDepth(root.right);
      return Math.max(left, right) + 1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
