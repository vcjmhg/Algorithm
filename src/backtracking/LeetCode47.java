package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode47 {
  List<List<Integer>> result = new ArrayList<>();
  byte[] visited = new byte[22];

  public List<List<Integer>> permuteUnique(int[] nums) {
    LinkedList<Integer> track = new LinkedList<>();
    Arrays.sort(nums);
    backtrace(nums, track);
    return result;
  }

  private void backtrace(int[] nums, LinkedList<Integer> track) {
    // 倡导到达nums.lenghth则记录路径
    if (nums.length == track.size()) {
      result.add(new LinkedList<>(track));
    }
    for (int i = 0; i < nums.length; i++) {
      //已经添加过的元素直接跳过
      if (visited[i] == 1) {
        continue;
      }
      //与上一个元素相同，且没有添加过直接跳过
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
