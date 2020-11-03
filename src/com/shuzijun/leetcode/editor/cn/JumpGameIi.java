// Given an array of non-negative integers nums, you are initially positioned at
// the first index of the array.
//
// Each element in the array represents your maximum jump length at that positio
// n.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// You can assume that you can always reach the last index.
//
//
// Example 1:
//
//
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
// step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
// Input: nums = [2,3,0,1,4]
// Output: 2
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics 贪心算法 数组
// 👍 739 👎 0

package com.shuzijun.leetcode.editor.cn;

public class JumpGameIi {
  public static void main(String[] args) {
    Solution solution = new JumpGameIi().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      if (n == 0) {
        return 0;
      }
      int end = 0, formost = 0, jump = 0;
      for (int i = 0; i < n - 1; i++) {
        formost = Math.max(formost, nums[i] + i);
        if (end == i) {
          jump++;
          end = formost;
        }
      }
      return jump;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
