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
      int n = envelopes.length;
      Arrays.sort(
          envelopes,
          new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
              return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
          });
      int[] height = new int[n];
      for (int i = 0; i < n; i++) {
        height[i] = envelopes[i][1];
      }
      return lengthOfLIS(height);
    }

    /* 返回 nums 中 LIS 的长度 */
    public int lengthOfLIS(int[] nums) {
      int piles = 0, n = nums.length;
      int[] top = new int[n];
      for (int i = 0; i < n; i++) {
        // 要处理的扑克牌
        int poker = nums[i];
        int left = 0, right = piles;
        // 二分查找插入位置
        while (left < right) {
          int mid = (left + right) / 2;
          if (top[mid] >= poker) {
            right = mid;
          } else {
            left = mid + 1;
          }
        }
        if (left == piles) {
          piles++;
        }
        // 把这张牌放到牌堆顶
        top[left] = poker;
      }
      // 牌堆数就是 LIS 长度
      return piles;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
