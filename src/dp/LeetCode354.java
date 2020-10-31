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

  /**
   * 使用二分查找法来解决信封嵌套问题
   * @param envelopes
   * @return
   */
  public int maxEnvelopes2(int[][] envelopes) {
    int n = envelopes.length;
    Arrays.sort(
            envelopes,
            new Comparator<int[]>() {
              @Override
              public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
              }
            });
    int[] height = new int[n];
    for (int i = 0; i < n; i++) {
      height[i] = envelopes[i][1];
    }
    return lengthOfLIS(height);
  }

  /* 返回 nums 中 LIS 的长度 */
  public int lengthOfLIS(int[] nums) {
    int piles = 0, n = nums.length;
    int[] top = new int[n];
    for (int i = 0; i < n; i++) {
      // 要处理的扑克牌
      int poker = nums[i];
      int left = 0, right = piles;
      // 二分查找插入位置
      while (left < right) {
        int mid = (left + right) / 2;
        if (top[mid] >= poker) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      if (left == piles) {
        piles++;
      }
      // 把这张牌放到牌堆顶
      top[left] = poker;
    }
    // 牌堆数就是 LIS 长度
    return piles;
  }
}
