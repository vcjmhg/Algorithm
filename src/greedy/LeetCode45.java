package greedy;

public class LeetCode45 {
  /**
   * 使用贪心算法解决跳跃游戏
   * @param nums
   * @return
   */
  public int jump(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    int end = 0, formost = 0, jump = 0;
    for (int i = 0; i < n - 1; i++) {
      formost = Math.max(formost, nums[i] + i);
      if (end == i) {
        jump++;
        end = formost;
      }
    }
    return jump;
  }
}
