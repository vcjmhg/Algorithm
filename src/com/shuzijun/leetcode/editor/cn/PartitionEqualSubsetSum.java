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
  // leetcode submit region end(Prohibit modification and deletion)

}
