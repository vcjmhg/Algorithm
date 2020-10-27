package bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode260 {
  /**
   * 从分类的角度结合位运算来解决
   * 基本思路如下：
   * 1. 对比LeetCode 136，我们发现这个问题的复杂性在于独特的数字是两个而不只是一个，而是两个。因而考虑能否通过分类将这两个独特的数据分成两个类别
   * 2. 相同的数据自然而然的会被分成同一类，然后针对每一类别都只有一个独特的数据，问题就转换成了LeetCode136那个最简单的形式
   * @param nums 需要判断的数组
   * @return 两个独特的数字
   */
  public int[] singleNumber(int[] nums) {
    int xorVal = 0;
    for (int num : nums) {
      xorVal ^= num;
    }
    // 获取最后一个 1
    xorVal = (xorVal & (xorVal - 1)) ^ xorVal;

    int res[] = new int[2];
    //根据和xorVal的与运算结果不同进行分类
    for (int num : nums) {
      if ((num & xorVal) == 0) {
        res[0] ^= num;
      } else {
        res[1] ^= num;
      }
    }
    return res;
  }

  /**
   * 通过map赋值计数和过滤
   * @param nums
   * @return
   */
  public int[] singleNumbe2r(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      if (e.getValue() == 1) {
        result.add(e.getKey());
      }
    }
    return new int[] {result.get(0), result.get(1)};
  }
}
