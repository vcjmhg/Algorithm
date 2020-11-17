// Given a collection of integers that might contain duplicates, nums, return all
// possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: [1,2,2]
// Output:
// [
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
// ]
//
// Related Topics 数组 回溯算法
// 👍 343 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsIi {
  public static void main(String[] args) {
    Solution solution = new SubsetsIi().new Solution();
    int[] mums = {1, 2, 2, 2};
    List<List<Integer>> result = solution.subsetsWithDup(mums);
    for (List<Integer> res : result) {
      System.out.println(res);
    }
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
      LinkedList<Integer> track = new LinkedList<>();
      Arrays.sort(nums);
      backtrace(nums, track, 0);
      return result;
    }

    private void backtrace(int[] nums, LinkedList<Integer> track, int cur) {
      // add track
      result.add(new LinkedList<>(track));
      for (int i = cur; i < nums.length; i++) {
        // 排序之后，如果再遇到重复元素，则不选择此元素
        if (i != cur && nums[i] == nums[i - 1]) {
          continue;
        }
        track.add(nums[i]);
        backtrace(nums, track, i + 1);
        track.removeLast();
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
