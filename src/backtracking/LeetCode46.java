package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 使用回溯法，解决全排列问题
     * @param nums
     * @return
     */
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
