// You are given coins of different denominations and a total amount of money amo
// unt. Write a function to compute the fewest number of coins that you need to mak
// e up that amount. If that amount of money cannot be made up by any combination o
// f the coins, return -1.
//
// You may assume that you have an infinite number of each kind of coin.
//
//
// Example 1:
//
//
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
//
//
// Example 2:
//
//
// Input: coins = [2], amount = 3
// Output: -1
//
//
// Example 3:
//
//
// Input: coins = [1], amount = 0
// Output: 0
//
//
// Example 4:
//
//
// Input: coins = [1], amount = 1
// Output: 1
//
//
// Example 5:
//
//
// Input: coins = [1], amount = 2
// Output: 2
//
//
//
// Constraints:
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 891 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CoinChange {
  public static void main(String[] args) {
    Solution solution = new CoinChange().new Solution();
    int[] coins = {1, 2, 5};
    int amount = 11;

    int result = solution.coinChange(coins, amount);

    System.out.println(result);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int coinChange(int[] coins, int amount) {
      if (amount < 0) {
        return -1;
      }
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
      return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
