// Given a non negative integer number num. For every numbers i in the range 0 ≤
// i ≤ num calculate the number of 1's in their binary representation and return th
// em as an array.
//
// Example 1:
//
//
// Input: 2
// Output: [0,1,1]
//
// Example 2:
//
//
// Input: 5
// Output: [0,1,1,2,1,2]
//
//
// Follow up:
//
//
// It is very easy to come up with a solution with run time O(n*sizeof(integer))
// . But can you do it in linear time O(n) /possibly in a single pass?
// Space complexity should be O(n).
// Can you do it like a boss? Do it without using any builtin function like __bu
// iltin_popcount in c++ or in any other language.
// Related Topics 位运算 动态规划
// 👍 433 👎 0

package com.shuzijun.leetcode.editor.cn;

public class CountingBits {
  public static void main(String[] args) {
    Solution solution = new CountingBits().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] countBits(int num) {
      int[] result = new int[num + 1];
      for (int i = 0; i <= num; i++) {
        result[i] = getCount(i);
      }
      return result;
    }
    // count the num of 1
    private int getCount(int n) {
      int count = 0;
      while (n != 0) {
        n = n & (n - 1);
        count++;
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
