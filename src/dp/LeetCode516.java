package dp;

public class LeetCode516 {
  /**
   * 使用动态规划解决最长回文子序列
   * dp数组的含义：
   * dp【i】【j】，字符串s从i到j最长回文子序列的个数。
   * 注意点：
   * 此处的遍历方向比较特殊，是从后向前遍历的
   * @param s
   * @return
   */
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

  /**
   * 通过状态压缩来对dp数组进行优化
   * @param s
   * @return
   */
  public int longestPalindromeSubseq2(String s) {
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
