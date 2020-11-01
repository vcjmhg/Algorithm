// Given a non-empty array nums containing only positive integers, find if the ar
// ray can be partitioned into two subsets such that the sum of elements in both su
// bsets is equal.
//
//
// Example 1:
//
//
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
// Related Topics 动态规划
// 👍 575 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.lang.management.ManagementFactory;

public class PartitionEqualSubsetSum {
  public static void main(String[] args) {
    Solution solution = new PartitionEqualSubsetSum().new Solution();
    int[] nums = {1, 5, 11, 5};
    boolean ans = solution.canPartition(nums);

    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
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
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
