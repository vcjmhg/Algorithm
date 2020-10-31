// Given two words word1 and word2, find the minimum number of operations require
// d to convert word1 to word2.
//
// You have the following 3 operations permitted on a word:
//
//
// Insert a character
// Delete a character
// Replace a character
//
//
// Example 1:
//
//
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation:
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
//
//
// Example 2:
//
//
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation:
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
//
// Related Topics 字符串 动态规划
// 👍 1221 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;

public class EditDistance {
  public static void main(String[] args) {
    Solution solution = new EditDistance().new Solution();
    String word1 = "intention";
    String word2 = "execution";

    int ans = solution.minDistance(word1, word2);
    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minDistance(String word1, String word2) {
      int m = word1.length(), n = word2.length();
      int[][] dp = new int[m + 1][n + 1];
      for (int[] temp : dp) {
        Arrays.fill(temp, Integer.MAX_VALUE);
      }
      // dp table 实际偏移了一位
      // base case
      for (int i = 0; i <= m; i++) {
        dp[i][0] = i;
      }
      for (int i = 0; i <= n; i++) {
        dp[0][i] = i;
      }

      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
          } else {
            dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
          }
        }
      }
      return dp[m][n];
    }

    private int min(int a, int b, int c) {
      a = Math.min(a, b);
      return Math.min(a, c);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
