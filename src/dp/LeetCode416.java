package dp;

public class LeetCode416 {
  /**
   * 使用零一背包的思想解决分割等和子集问题
   * 基本思路：
   * 将分割子集问题看成是在已知容量是sum/2的情况下，可以放入背包的最大数量，在获取其最大数量后
   * ，比较能够装入的最大数量是否等于sum/2，如果相等则郑光明可以进行划分，否则不可以进行划分
   * @param nums
   * @return
   */
  public boolean canPartition(int[] nums) {
    if (nums.length == 0) {
      return true;
    }
    int N = nums.length;
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += nums[i];
    }
    if ((sum & 1) == 1) {
      return false;
    }
    int halfSum = sum / 2;
    int[][] dp = new int[N + 1][halfSum + 1];
    for (int i = 1; i <= N; i++) {
      for (int w = 1; w <= halfSum; w++) {
        if (w < nums[i - 1]) {
          dp[i][w] = dp[i - 1][w];
        } else {
          dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - nums[i - 1]] + nums[i - 1]);
        }
      }
    }
    return dp[N][halfSum] == halfSum;
  }

  /**
   * 对状态进行压缩，因为递推的过程中只用到了两个状态，因此可以通过状态压缩进行优化
   * @param nums
   * @return
   */
  public boolean canPartition2(int[] nums) {
    int sum = 0, n = nums.length;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    sum = sum / 2;
    boolean [] dp=new boolean[sum + 1] ;
    // base case
    dp[0] = true;

    for (int i = 0; i < n; i++)
      for (int j = sum; j >= 0; j--) {
        if (j - nums[i] >= 0) {
          dp[j] = dp[j] || dp[j - nums[i]];
        }
      }

    return dp[sum];
  }
}
