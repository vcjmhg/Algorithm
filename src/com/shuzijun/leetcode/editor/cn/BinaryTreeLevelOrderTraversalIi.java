// Given a binary tree, return the bottom-up level order traversal of its nodes'
// values. (ie, from left to right, level by level from leaf to root).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// return its bottom-up level order traversal as:
//
// [
//  [15,7],
//  [9,20],
//  [3]
// ]
//
// Related Topics 树 广度优先搜索
// 👍 354 👎 0

package com.shuzijun.leetcode.editor.cn;

import tree.TreeNode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {
  public static void main(String[] args) {
    Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      if (root == null) {
        return new ArrayList<>();
      }
      Queue<TreeNode> queue = new LinkedList<>();
      List<List<Integer>> result = new ArrayList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int sz = queue.size();
        List<Integer> temp = new LinkedList<>();
        for (int i = 0; i < sz; i++) {
          TreeNode cur = queue.poll();
          temp.add(cur.val);
          if (cur.left != null) {
            queue.add(cur.left);
          }
          if (cur.right != null) {
            queue.add(cur.right);
          }
        }
        result.add(temp);
      }
      Collections.reverse(result);
      return result;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
