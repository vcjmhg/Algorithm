package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode78 {
  /**
   * 对选择的方式进行了修改，最终获得了不错的运行速度
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets2(int[] nums) {
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
      //从i+1开始效率会更高
      backtrace(nums, track, i + 1);
      track.removeLast();
    }
  }

  List<List<Integer>> result = new LinkedList<>();
  /**
   * 套用模板来解决子集问题，存在时间复杂度过高超时的问题
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    LinkedList<Integer> track = new LinkedList<>();
    backtrace(nums, track);
    return result;
  }

  /**
   * @param nums 记录所有选择
   * @param track 路径
   */
  private void backtrace(int[] nums, LinkedList<Integer> track) {
    if (!contains(track)) {
      result.add(new LinkedList<>(track));
    }
    // make choice
    for (int i = 0; i < nums.length; i++) {
      if (track.contains(nums[i])) {
        continue;
      }
      track.add(nums[i]);
      backtrace(nums, track);
      track.removeLast();
    }
  }

  private boolean contains(LinkedList<Integer> track) {
    if (track.size() <= 1) {
      return false;
    }
    int pre = Integer.MIN_VALUE;
    for (int cur : track) {
      if (pre >= cur) {
        return true;
      }
      pre = cur;
    }
    return false;
  }
}
