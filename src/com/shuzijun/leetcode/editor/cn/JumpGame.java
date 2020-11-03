// Given an array of non-negative integers, you are initially positioned at the f
// irst index of the array.
//
// Each element in the array represents your maximum jump length at that positio
// n.
//
// Determine if you are able to reach the last index.
//
//
// Example 1:
//
//
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jum
// p length is 0, which makes it impossible to reach the last index.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 10^4
// 0 <= nums[i][j] <= 10^5
//
// Related Topics 贪心算法 数组
// 👍 902 👎 0

package com.shuzijun.leetcode.editor.cn;

public class JumpGame {
  public static void main(String[] args) {
    Solution solution = new JumpGame().new Solution();
    int[] nums = {3, 2, 1, 0, 4};
    boolean ans = solution.canJump(nums);
    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canJump(int[] nums) {
      int n = nums.length;
      int farthest = 0;
      for (int i = 0; i < n - 1; i++) {
        // 不断计算能跳到的最远距离
        farthest = Math.max(farthest, i + nums[i]);
        // 可能碰到了 0，卡住跳不动了
        if (farthest <= i) {
          return false;
        }
      }
      return farthest >= n - 1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
