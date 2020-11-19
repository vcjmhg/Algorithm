// Given an array of intervals where intervals[i] = [starti, endi], merge all ove
// rlapping intervals, and return an array of the non-overlapping intervals that co
// ver all the intervals in the input.
//
//
// Example 1:
//
//
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
//
// Constraints:
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 排序 数组
// 👍 699 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.*;

public class MergeIntervals {
  public static void main(String[] args) {
    Solution solution = new MergeIntervals().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] merge(int[][] intervals) {
      LinkedList<int[]> results = new LinkedList<>();
      // 区间左侧升序排列，区间右侧降序排列
      Arrays.sort(
          intervals,
          new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
              }
              return Integer.compare(o1[0], o2[0]);
            }
          });
      int left = intervals[0][0], right = intervals[0][1];
      results.add(new int[] {left, right});
      int[] interv;
      for (int i = 0; i < intervals.length; i++) {
        interv = intervals[i];
        if (right >= interv[0] && right < interv[1]) {
          results.removeLast();
          results.add(new int[] {left, interv[1]});
          right = interv[1];
        }
        if (right < interv[0]) {
          results.add(new int[] {interv[0], interv[1]});
          left = interv[0];
          right = interv[1];
        }
      }
      int[][] resultArray = new int[results.size()][2];
      for (int i = 0; i < results.size(); i++) {
        resultArray[i] = results.get(i);
      }
      return resultArray;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
