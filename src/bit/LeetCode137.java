package bit;

import java.util.HashMap;
import java.util.Map;

public class LeetCode137 {
  /**
   * 通过map来解决该问题
   * @param nums
   * @return
   */
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
