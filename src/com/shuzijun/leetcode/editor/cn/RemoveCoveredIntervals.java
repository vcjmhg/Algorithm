// Given a list of intervals, remove all intervals that are covered by another in
// terval in the list.
//
// Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
//
//
// After doing so, return the number of remaining intervals.
//
//
// Example 1:
//
//
// Input: intervals = [[1,4],[3,6],[2,8]]
// Output: 2
// Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
//
//
// Example 2:
//
//
// Input: intervals = [[1,4],[2,3]]
// Output: 1
//
//
// Example 3:
//
//
// Input: intervals = [[0,10],[5,12]]
// Output: 2
//
//
// Example 4:
//
//
// Input: intervals = [[3,10],[4,10],[5,11]]
// Output: 2
//
//
// Example 5:
//
//
// Input: intervals = [[1,2],[1,4],[3,4]]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= intervals.length <= 1000
// intervals[i].length == 2
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5
// All the intervals are unique.
// Related Topics 贪心算法 排序 Line Sweep
// 👍 22 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
  public static void main(String[] args) {
    Solution solution = new RemoveCoveredIntervals().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
      // 将左区间升序排序，右区间降序排序
      Arrays.sort(
          intervals,
          new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              int compareResult = 0;
              if (o1[0] < o2[0]) {
                compareResult = -1;
              } else if (o1[0] > o2[0]) {
                compareResult = 1;
              } else {
                compareResult = Integer.compare(o2[1], o1[1]);
              }
              return compareResult;
            }
          });
      // 分三种情况进行处理
      int res = 0;
      int left = intervals[0][0], right = intervals[0][1];
      for (int i = 1; i < intervals.length; i++) {
        int[] interval = intervals[i];
        // case 1
        if (left <= interval[0] && right >= interval[1]) {
          res++;
        }
        // case 2
        if (right < interval[1] && right > interval[0]) {
          right = interval[1];
        }
        // case 3
        if (right < interval[0]) {
          left = interval[0];
          right = interval[1];
        }
      }
      return intervals.length - res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
