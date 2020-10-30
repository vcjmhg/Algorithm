package dp;

import java.util.Arrays;

public class LeetCode300 {
  /**
   * 使用动态规划解决最大递增子串问题
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    //初始化为1，因为如果nums不为空最少的子串数量为1
    Arrays.fill(dp, 1);
    //dp[n]定义为以nums【n】结尾的递增串的数量
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int res = 0;
    
    
    
    
    for (int i = 0; i < dp.length; i++) {
      if (dp[i] > res) {
        res = dp[i];
      }
    }
    return res;
  }
}
