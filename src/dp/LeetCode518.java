package dp;

public class LeetCode518 {
  /**
   * 该问题是一个完全背包问题，即在背包中放置物品时，物品的数量不限制
   * 基本思路：
   * dp【i】【j】含义：从前i个硬币中凑钱，凑成j数额的钱有的方法数量时dp【i】【j】
   * 初始条件为dp【0】【...】=0,dp【..】【0】=1
   * 两种情况：j小于第i中零钱的份额，另一种时大于等于
   * @param amount
   * @param coins
   * @return
   */
  public int change(int amount, int[] coins) {
    int N = coins.length;
    int[][] dp = new int[N + 1][amount + 1];
    for (int i = 0; i <= N; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j < coins[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
        }
      }
    }
    return dp[N][amount];
  }
}
