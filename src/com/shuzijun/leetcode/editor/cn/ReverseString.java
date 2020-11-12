// Write a function that reverses a string. The input string is given as an array
// of characters char[].
//
// Do not allocate extra space for another array, you must do this by modifying
// the input array in-place with O(1) extra memory.
//
// You may assume all the characters consist of printable ascii characters.
//
//
//
//
// Example 1:
//
//
// Input: ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
//
//
//
// Example 2:
//
//
// Input: ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
//
//
//
// Related Topics 双指针 字符串
// 👍 325 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;

public class ReverseString {
  public static void main(String[] args) {
    Solution solution = new ReverseString().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void reverseString(char[] s) {
      if (s.length == 1) {
        return;
      }
      char temp;
      for (int i = 0; i < s.length / 2; i++) {
        temp = s[i];
        s[i] = s[s.length - i - 1];
        s[s.length - i - 1] = temp;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
