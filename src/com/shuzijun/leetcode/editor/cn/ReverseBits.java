// Reverse bits of a given 32 bits unsigned integer.
//
// Note:
//
//
// Note that in some languages such as Java, there is no unsigned integer type.
// In this case, both input and output will be given as a signed integer type. They
// should not affect your implementation, as the integer's internal binary represe
// ntation is the same, whether it is signed or unsigned.
// In Java, the compiler represents the signed integers using 2's complement not
// ation. Therefore, in Example 2 above, the input represents the signed integer -3
// and the output represents the signed integer -1073741825.
//
//
// Follow up:
//
// If this function is called many times, how would you optimize it?
//
//
// Example 1:
//
//
// Input: n = 00000010100101000001111010011100
// Output:    964176192 (00111001011110000010100101000000)
// Explanation: The input binary string 00000010100101000001111010011100 represen
// ts the unsigned integer 43261596, so return 964176192 which its binary represent
// ation is 00111001011110000010100101000000.
//
//
// Example 2:
//
//
// Input: n = 11111111111111111111111111111101
// Output:   3221225471 (10111111111111111111111111111111)
// Explanation: The input binary string 11111111111111111111111111111101 represen
// ts the unsigned integer 4294967293, so return 3221225471 which its binary repres
// entation is 10111111111111111111111111111111.
//
//
//
// Constraints:
//
//
// The input must be a binary string of length 32
//
// Related Topics 位运算
// 👍 222 👎 0

package com.shuzijun.leetcode.editor.cn;

public class ReverseBits {
  public static void main(String[] args) {
    Solution solution = new ReverseBits().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
      n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
      n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
      n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
      n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
      return n;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
