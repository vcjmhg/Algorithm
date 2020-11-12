// Given an integer n, generate all structurally unique BST's (binary search tree
// s) that store values 1 ... n.
//
// Example:
//
//
// Input: 3
// Output:
// [
//   [1,null,3,2],
//   [3,2,null,1],
//   [3,1,null,null,2],
//   [2,1,3],
//   [1,null,2,null,3]
// ]
// Explanation:
// The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//
//
// Constraints:
//
//
// 0 <= n <= 8
//
// Related Topics 树 动态规划
// 👍 696 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesIi {
  public static void main(String[] args) {
    Solution solution = new UniqueBinarySearchTreesIi().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class Solution {
    public List<TreeNode> generateTrees(int n) {
      if (n == 0) {
        return new LinkedList<TreeNode>();
      }
      return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
      List<TreeNode> allTrees = new LinkedList<TreeNode>();
      if (start > end) {
        allTrees.add(null);
        return allTrees;
      }

      // 枚举可行根节点
      for (int i = start; i <= end; i++) {
        // 获得所有可行的左子树集合
        List<TreeNode> leftTrees = generateTrees(start, i - 1);

        // 获得所有可行的右子树集合
        List<TreeNode> rightTrees = generateTrees(i + 1, end);

        // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
        for (TreeNode left : leftTrees) {
          for (TreeNode right : rightTrees) {
            TreeNode currTree = new TreeNode(i);
            currTree.left = left;
            currTree.right = right;
            allTrees.add(currTree);
          }
        }
      }
      return allTrees;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
