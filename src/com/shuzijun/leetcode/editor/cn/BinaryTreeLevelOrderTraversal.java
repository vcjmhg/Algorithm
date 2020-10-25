// Given a binary tree, return the level order traversal of its nodes' values. (i
// e, from left to right, level by level).
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
// return its level order traversal as:
//
// [
//  [3],
//  [9,20],
//  [15,7]
// ]
//
// Related Topics 树 广度优先搜索
// 👍 673 👎 0

package com.shuzijun.leetcode.editor.cn;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;
    List<List<Integer>> result = solution.levelOrder(root);
    for (List<Integer> r:result){
      System.out.println(r);
    }
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return new ArrayList<>();
      }
      Queue<TreeNode> queue = new LinkedList<>();
      List<List<Integer>> result = new ArrayList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int sz = queue.size();
        List<Integer> temp = new ArrayList<>();
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
      return result;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
