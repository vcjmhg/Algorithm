// You are given coins of different denominations and a total amount of money. Wr
// ite a function to compute the number of combinations that make up that amount. Y
// ou may assume that you have infinite number of each kind of coin.
//
//
//
//
//
//
// Example 1:
//
//
// Input: amount = 5, coins = [1, 2, 5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
//
//
// Example 2:
//
//
// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.
//
//
// Example 3:
//
//
// Input: amount = 10, coins = [10]
// Output: 1
//
//
//
//
// Note:
//
// You can assume that
//
//
// 0 <= amount <= 5000
// 1 <= coin <= 5000
// the number of coins is less than 500
// the answer is guaranteed to fit into signed 32-bit integer
//
// 👍 262 👎 0

package com.shuzijun.leetcode.editor.cn;

public class CoinChange2 {
  public static void main(String[] args) {
    Solution solution = new CoinChange2().new Solution();
    int amount = 5;
    int[] coins = {1, 2, 5};
    int ans = solution.change(amount, coins);
    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
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
  // leetcode submit region end(Prohibit modification and deletion)

}
