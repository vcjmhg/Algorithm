// Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND o
// f all numbers in this range, inclusive.
//
// Example 1:
//
//
// Input: [5,7]
// Output: 4
//
//
// Example 2:
//
//
// Input: [0,1]
// Output: 0 Related Topics 位运算
// 👍 238 👎 0

package com.shuzijun.leetcode.editor.cn;

public class BitwiseAndOfNumbersRange {
  public static void main(String[] args) {
    Solution solution = new BitwiseAndOfNumbersRange().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int rangeBitwiseAnd(int m, int n) {
      // m 要赋值给 i，所以提前判断一下
      if (m == Integer.MAX_VALUE) {
        return m;
      }
      int res = m;
      for (int i = m + 1; i <= n; i++) {
        res &= i;
        if (res == 0 || i == Integer.MAX_VALUE) {
          break;
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
