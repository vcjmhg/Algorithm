// Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order.
//
//
// Example 1:
//
//
// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// Example 2:
//
//
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 回溯算法
// 👍 525 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.*;

public class PermutationsIi {
  public static void main(String[] args) {
    Solution solution = new PermutationsIi().new Solution();
    int[] nums = {1, 1, 2};
    List<List<Integer>> result = solution.permuteUnique(nums);
    for (List<Integer> res : result) {
      System.out.println(res);
    }
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> result = new ArrayList<>();
    byte[] visited = new byte[22];

    public List<List<Integer>> permuteUnique(int[] nums) {
      LinkedList<Integer> track = new LinkedList<>();
      Arrays.sort(nums);
      backtrace(nums, track);
      return result;
    }

    private void backtrace(int[] nums, LinkedList<Integer> track) {

      if (nums.length == track.size()) {
        result.add(new LinkedList<>(track));
      }
      for (int i = 0; i < nums.length; i++) {
        if (visited[i] == 1) {
          continue;
        }
        if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
          continue;
        }
        visited[i] = 1;
        track.add(nums[i]);
        backtrace(nums, track);
        track.removeLast();
        visited[i] = 0;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
