// Given a string s, find the longest palindromic subsequence's length in s. You
// may assume that the maximum length of s is 1000.
//
// Example 1:
// Input:
//
//
// "bbbab"
//
// Output:
//
//
// 4
//
// One possible longest palindromic subsequence is "bbbb".
//
//
//
// Example 2:
// Input:
//
//
// "cbbd"
//
// Output:
//
//
// 2
//
// One possible longest palindromic subsequence is "bb".
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consists only of lowercase English letters.
//
// Related Topics 动态规划
// 👍 322 👎 0

package com.shuzijun.leetcode.editor.cn;

public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    Solution solution = new LongestPalindromicSubsequence().new Solution();
    String s = "asdfafdafd";
    int ans = solution.longestPalindromeSubseq(s);

    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestPalindromeSubseq(String s) {
      // border case
      if (s.length() == 0) {
        return 0;
      }
      int n = s.length();
      int[] dp = new int[n];
      for (int i = 0; i < n; i++) {
        dp[i] = 1;
      }

      int pre, temp;
      for (int i = n - 2; i >= 0; i--) {
        pre = 0;
        for (int j = i + 1; j < dp.length; j++) {
          temp = dp[j];
          if (s.charAt(i) == s.charAt(j)) {
            dp[j] = pre + 2;
          } else {
            dp[j] = Math.max(dp[j], dp[j - 1]);
          }
          pre = temp;
        }
      }
      return dp[n - 1];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
