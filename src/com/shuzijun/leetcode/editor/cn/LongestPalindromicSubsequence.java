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
      int[][] dp = new int[s.length()][s.length()];
      for (int i = 0; i < s.length(); i++) {
        dp[i][i] = 1;
      }

      for (int i = dp.length - 2; i >= 0; i--) {
        for (int j = i + 1; j < dp.length; j++) {
          if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dp[i + 1][j - 1] + 2;
          } else {
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
          }
        }
      }
      return dp[0][s.length() - 1];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
