// Given an array nums of distinct integers, return all the possible permutations
// . You can return the answer in any order.
//
//
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:
// Input: nums = [1]
// Output: [[1]]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.
//
// Related Topics 回溯算法
// 👍 994 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
  public static void main(String[] args) {
    Solution solution = new Permutations().new Solution();
    int nums[] = {1, 2, 3};
    List<List<Integer>> result = solution.permute(nums);
    for (List<Integer> res : result) {
      System.out.println(res);
    }
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
      LinkedList<Integer> track = new LinkedList<>();
      backtrace(nums, track);
      return result;
    }

    private void backtrace(int[] nums, LinkedList<Integer> track) {
      // add track
      if (track.size() == nums.length) {
        result.add(new LinkedList<>(track));
      }
      for (int num : nums) {
        if (track.contains(num)) {
          continue;
        }
        // make choice
        track.add(num);
        // recursive
        backtrace(nums, track);
        // backtrace choince
        track.removeLast();
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
