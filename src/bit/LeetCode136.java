package bit;

public class LeetCode136 {
  public int singleNumber(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result ^= nums[i];
    }
    return result;
  }
}
