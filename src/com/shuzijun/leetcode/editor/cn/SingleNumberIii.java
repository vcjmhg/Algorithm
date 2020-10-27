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

import java.util.*;

public class SingleNumberIii {
  public static void main(String[] args) {
    Solution solution = new SingleNumberIii().new Solution();
    int[] result = solution.singleNumber(new int[] {1, 2, 1, 3, 2, 5});
    System.out.println(result);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] singleNumber(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      }
      for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        if (e.getValue() == 1) {
          result.add(e.getKey());
        }
      }
      return new int[] {result.get(0), result.get(1)};
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
