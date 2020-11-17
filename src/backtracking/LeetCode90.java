package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode90 {
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
