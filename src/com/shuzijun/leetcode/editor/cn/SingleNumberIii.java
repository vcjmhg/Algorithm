// Given an integer array nums, in which exactly two elements appear only once an
// d all the other elements appear exactly twice. Find the two elements that appear
// only once. You can return the answer in any order.
//
// Follow up: Your algorithm should run in linear runtime complexity. Could you
// implement it using only constant space complexity?
//
//
// Example 1:
//
//
// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.
//
//
// Example 2:
//
//
// Input: nums = [-1,0]
// Output: [-1,0]
//
//
// Example 3:
//
//
// Input: nums = [0,1]
// Output: [1,0]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 30000
// Each integer in nums will appear twice, only two integers will appear once.
//
// Related Topics 位运算
// 👍 309 👎 0

package com.shuzijun.leetcode.editor.cn;

public class SingleNumberIii {
  public static void main(String[] args) {
    Solution solution = new SingleNumberIii().new Solution();
    int[] result = solution.singleNumber(new int[] {2, 1, 2, 3, 4, 1});
    System.out.println(result[0] + ", " + result[1]);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] singleNumber(int[] nums) {
      int xorVal = 0;
      for (int num : nums) {
        xorVal ^= num;
      }
      xorVal = (xorVal & (xorVal - 1)) ^ xorVal;

      int res[] = new int[2];
      for (int num : nums) {
        if ((num & xorVal) == 0) {
          res[0] ^= num;
        } else {
          res[1] ^= num;
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
