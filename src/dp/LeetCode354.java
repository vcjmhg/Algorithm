package dp;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode354 {
  /**
   * 使用动态规划来解决
   * dp[i]表示：
   * 包含第i个信封的最多套娃个数
   * @param envelopes
   * @return
   */
  public int maxEnvelopes(int[][] envelopes) {
    // border case
    if (envelopes.length == 0) {
      return 0;
    }
    Arrays.sort(
        envelopes,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
          }
        });
    int m = envelopes.length;
    int[] dp = new int[m];
    Arrays.fill(dp, 1);
    //      dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int ans = 1;
    for (int i = 0; i < dp.length; i++) {
      if (dp[i] > ans) {
        ans = dp[i];
      }
    }
    return ans;
  }
}
