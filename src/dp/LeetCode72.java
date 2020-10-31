package dp;

import java.util.Arrays;

public class LeetCode72 {
  /**
   * 使用动态规划解决
   *
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int[] temp : dp) {
      Arrays.fill(temp, Integer.MAX_VALUE);
    }
    // dp table 实际偏移了一位
    // base case
    /** dp数组含义如下： dp【i】【j】表示从word1的-1 - i-1位置字符复制成word2 -1 - j-1的字符所需要的操作步数 */
    for (int i = 0; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= n; i++) {
      dp[0][i] = i;
    }
    /** 需要考虑的两种情况： 
     * 1. word1的i-1位置的字符是否和word的j-1位置的字符是否相同，如果相同从word1的-1到i-1位置复制到word2的-1
     * 到j-1位置的字符和从word1的-1到 i-2位置到wrod2的-1到j-2位置所需的操作步骤数相同。
     * 2. 两者不相等，尝试从上一步的增删改三种操作中选择出操作数最小的来保证两者相等
     * */
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
