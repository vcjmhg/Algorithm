// The Hamming distance between two integers is the number of positions at which
// the corresponding bits are different.
//
// Given two integers x and y, calculate the Hamming distance.
//
// Note:
// 0 ≤ x, y < 231.
//
//
// Example:
//
// Input: x = 1, y = 4
//
// Output: 2
//
// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//       ↑   ↑
//
// The above arrows point to positions where the corresponding bits are different
// .
//
// Related Topics 位运算
// 👍 341 👎 0

package com.shuzijun.leetcode.editor.cn;

public class HammingDistance {
  public static void main(String[] args) {
    Solution solution = new HammingDistance().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int hammingDistance(int x, int y) {
      x = x ^ y;
      int count = 0;
      while (x != 0) {
        x = x & (x - 1);
        count++;
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
