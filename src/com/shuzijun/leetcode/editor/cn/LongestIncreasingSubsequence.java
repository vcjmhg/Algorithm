// Given an unsorted array of integers, find the length of longest increasing sub
// sequence.
//
// Example:
//
//
// Input: [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
// length is 4.
//
// Note:
//
//
// There may be more than one LIS combination, it is only necessary for you to r
// eturn the length.
// Your algorithm should run in O(n2) complexity.
//
//
// Follow up: Could you improve it to O(n log n) time complexity?
// Related Topics 二分查找 动态规划
// 👍 1122 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    Solution solution = new LongestIncreasingSubsequence().new Solution();
    int [] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    int ans = solution.lengthOfLIS(nums);
    
    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      Arrays.fill(dp, 1);
      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < i; j++) {
          if (nums[i] > nums[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
      }
      int res = 0;
      for (int i = 0; i < dp.length; i++) {
        if (dp[i] > res) {
          res = dp[i];
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
