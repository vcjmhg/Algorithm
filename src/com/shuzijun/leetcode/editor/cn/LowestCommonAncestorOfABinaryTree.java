// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
// in the tree.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor
// is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).”
//
//
// Example 1:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
//
//
// Example 2:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant o
// f itself according to the LCA definition.
//
//
// Example 3:
//
//
// Input: root = [1,2], p = 1, q = 2
// Output: 1
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the tree.
//
// Related Topics 树
// 👍 798 👎 0

package com.shuzijun.leetcode.editor.cn;

import tree.TreeNode;

import java.util.TreeMap;

public class LowestCommonAncestorOfABinaryTree {
  public static void main(String[] args) {
    Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || p == root || q == root) {
        return root;
      }
      TreeNode left =lowestCommonAncestor(root.left,p,q);
      TreeNode right=lowestCommonAncestor(root.right,p,q);
      if(left == null){
        return right;
      }
      if (right==null){
        return left;
      }
      //left equals null and left equals null
      return root;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
