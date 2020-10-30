package dp;

import java.util.HashMap;
import java.util.Map;

public class LeetCode322 {

  /**
   * 通过递归的方式来求解找零钱问题，本质上也是在进行动态规划前的重要一步。是确定状态的第一步
   *
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange(int[] coins, int amount) {
    return dp(coins, amount);
  }
  // 确定所有可能的选择，然后在所有的选择中找出最有的
  private int dp(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    int res = Integer.MAX_VALUE;
    int subproblem = 0;
    for (int conin : coins) {
      subproblem = dp(coins, amount - conin);
      if (subproblem == -1) {
        continue;
      }
      res = Math.min(res, subproblem + 1);
    }
    return res != Integer.MAX_VALUE ? res : -1;
  }

  // 通过备忘录对dp（）进行优化，消除重复子问题
  Map<Integer, Integer> memo = new HashMap<>();

  private int dp2(int[] coins, int n) {
    if (n < 0) {
      return -1;
    }
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    int res = Integer.MAX_VALUE;
    int subproblem = 0;
    for (int coin : coins) {
      subproblem = dp2(coins, n - coin);
      if (subproblem == -1) {
        continue;
      }
      res = Math.min(res, subproblem + 1);
    }
    if (res != Integer.MAX_VALUE) {
      memo.put(n, res);
      return res;
    }
    return -1;
  }

  /**
   * 通过dp数组来求解硬币问题
   * @param coins
   * @param amount
   * @return
   */
  public int coinChangeWithDp(int[] coins, int amount) {
    //边界情况判断
    if (amount < 0) {
      return -1;
    }
    //dp数组初始化，一般来说求最大值时，dp数组初始化城最小值，求最小值时dp数组初始化成一个较大的值
    int[] dp = new int[amount + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = amount + 1;
    }
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i - coin < 0) {
          continue;
        }
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
    // 如果对应位置dp数组的值时初值的话，证明没有任何一种组合可以组成硬币总数
    return (dp[amount] == amount + 1) ? -1 : dp[amount];
  }
}
