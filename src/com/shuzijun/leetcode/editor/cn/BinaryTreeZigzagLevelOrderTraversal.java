// Given a binary tree, return the zigzag level order traversal of its nodes' val
// ues. (ie, from left to right, then right to left for the next level and alternat
// e between).
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
// return its zigzag level order traversal as:
//
// [
//  [3],
//  [20,9],
//  [15,7]
// ]
//
// Related Topics 栈 树 广度优先搜索
// 👍 282 👎 0

package com.shuzijun.leetcode.editor.cn;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
  public static void main(String[] args) {
    Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      //border judge
      if (root == null){
        return new ArrayList<>();
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      List<List<Integer>> result = new LinkedList<>();
      boolean isReverse = true;
      while (!queue.isEmpty()) {
        int sz = queue.size();
        isReverse = !isReverse;
        LinkedList<Integer> temp = new LinkedList<>();
        for (int i = 0; i < sz; i++) {
          TreeNode cur = queue.poll();
          if (!isReverse){
            temp.add(cur.val);
          }else {
            temp.addFirst(cur.val);
          }
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
