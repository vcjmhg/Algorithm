package dp;

public class LeetCode53 {
  public int maxSubArray(int[] nums) {
    int m = nums.length;
    if (m == 0) {
      return Integer.MIN_VALUE;
    }
    int[] dp = new int[m];
    dp[0] = nums[0];
    for (int i = 1; i < m; i++) {
      dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      if (dp[i] > ans) {
        ans = dp[i];
      }
    }
    return ans;
  }
}
