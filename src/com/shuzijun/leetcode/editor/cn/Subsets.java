// Given an integer array nums, return all possible subsets (the power set).
//
// The solution set must not contain duplicate subsets.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// Example 2:
//
//
// Input: nums = [0]
// Output: [[],[0]]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
// Related Topics 位运算 数组 回溯算法
// 👍 877 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
  public static void main(String[] args) {
    Solution solution = new Subsets().new Solution();
    int[] nums = {1, 2, 3};
    List<List<Integer>> result = solution.subsets(nums);

    for (List<Integer> res : result) {
      System.out.println(res);
    }
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
      LinkedList<Integer> track = new LinkedList<>();
      Arrays.sort(nums);
      backtrace(nums, track, 0);
      return result;
    }

    /**
     * @param nums 记录所有选择
     * @param track 路径
     */
    private void backtrace(int[] nums, LinkedList<Integer> track, int cur) {
      result.add(new LinkedList<>(track));

      // make choice
      for (int i = cur; i < nums.length; i++) {
        if (!track.isEmpty() && track.getLast() >= nums[i]) {
          continue;
        }
        track.add(nums[i]);
        backtrace(nums, track, cur + 1);
        track.removeLast();
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
