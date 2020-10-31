// You have a number of envelopes with widths and heights given as a pair of inte
// gers (w, h). One envelope can fit into another if and only if both the width and
// height of one envelope is greater than the width and height of the other envelo
// pe.
//
// What is the maximum number of envelopes can you Russian doll? (put one inside
// other)
//
// Note:
// Rotation is not allowed.
//
// Example:
//
//
//
// Input: [[5,4],[6,4],[6,7],[2,3]]
// Output: 3
// Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3]
// => [5,4] => [6,7]).
//
//
// Related Topics 二分查找 动态规划
// 👍 218 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
  public static void main(String[] args) {
    Solution solution = new RussianDollEnvelopes().new Solution();
    // [[10,8],[1,12],[6,15],[2,18]]
    int[][] envelops = {
      {1, 1},
      {1, 1},
      {1, 1},
      {1, 1}
    };
    int ans = solution.maxEnvelopes(envelops);
    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      // border case
      if (envelopes.length == 0) {
        return 0;
      }
      Arrays.sort(
          envelopes,
          new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
              return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
          });
      int m = envelopes.length;
      int[] dp = new int[m];
      Arrays.fill(dp, 1);
//      dp[0] = 1;
      for (int i = 1; i < dp.length; i++) {
        for (int j = 0; j < i; j++) {
          if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
      }
      int ans = 1;
      for (int i = 0; i < dp.length; i++) {
        if (dp[i] > ans) {
          ans = dp[i];
        }
      }
      return ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
