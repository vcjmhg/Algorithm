// You are given the root node of a binary search tree (BST) and a value to inser
// t into the tree. Return the root node of the BST after the insertion. It is guar
// anteed that the new value does not exist in the original BST.
//
// Notice that there may exist multiple valid ways for the insertion, as long as
// the tree remains a BST after insertion. You can return any of them.
//
//
// Example 1:
//
//
// Input: root = [4,2,7,1,3], val = 5
// Output: [4,2,7,1,3,5]
// Explanation: Another accepted tree is:
//
//
//
// Example 2:
//
//
// Input: root = [40,20,60,10,30,50,70], val = 25
// Output: [40,20,60,10,30,50,70,null,null,25]
//
//
// Example 3:
//
//
// Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
// Output: [4,2,7,1,3,5]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree will be in the range [0, 104].
// -108 <= Node.val <= 108
// All the values Node.val are unique.
// -108 <= val <= 108
// It's guaranteed that val does not exist in the original BST.
//
// Related Topics 树
// 👍 134 👎 0

package com.shuzijun.leetcode.editor.cn;

import tree.TreeNode;

public class InsertIntoABinarySearchTree {
  public static void main(String[] args) {
    Solution solution = new InsertIntoABinarySearchTree().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
   * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
   */
  class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
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
  // leetcode submit region end(Prohibit modification and deletion)

}
