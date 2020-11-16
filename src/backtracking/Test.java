package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列问题
 */
public class Test {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    List<List<Integer>> result = new Test().permute(nums);

    for (List<Integer> trace : result) {
      System.out.println(trace);
    }
  }

  List<List<Integer>> result = new ArrayList<>();

  List<List<Integer>> permute(int[] nums) {
    // record trace
    LinkedList<Integer> trace = new LinkedList<>();
    backetrack(nums, trace);
    return result;
  }

  /**
   * @param nums
   * @param track
   */
  private void backetrack(int[] nums, LinkedList<Integer> track) {
    // 终止条件判断
    if (track.size() == nums.length) {
      result.add(new LinkedList<>(track));
      return;
    }
    // 选择
    for (int i = 0; i < nums.length; i++) {
      if (track.contains(nums[i])) {
        continue;
      }
      // 做选择
      track.add(nums[i]);
      backetrack(nums, track);
      // 撤销选择
      track.removeLast();
    }
  }
}
