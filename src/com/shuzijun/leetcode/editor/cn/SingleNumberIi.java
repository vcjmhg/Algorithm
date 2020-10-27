// Given a non-empty array of integers, every element appears three times except
// for one, which appears exactly once. Find that single one.
//
// Note:
//
// Your algorithm should have a linear runtime complexity. Could you implement i
// t without using extra memory?
//
// Example 1:
//
//
// Input: [2,2,3,2]
// Output: 3
//
//
// Example 2:
//
//
// Input: [0,1,0,1,0,1,99]
// Output: 99
// Related Topics 位运算
// 👍 450 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIi {
  public static void main(String[] args) {
    Solution solution = new SingleNumberIi().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int singleNumber(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      }
      for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        if (e.getValue() == 1) {
          return e.getKey();
        }
      }
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
