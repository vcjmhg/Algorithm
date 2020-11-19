// Given two lists of closed intervals, each list of intervals is pairwise disjoi
// nt and in sorted order.
//
// Return the intersection of these two interval lists.
//
// (Formally, a closed interval [a, b] (with a <= b) denotes the set of real num
// bers x with a <= x <= b. The intersection of two closed intervals is a set of re
// al numbers that is either empty, or can be represented as a closed interval. For
// example, the intersection of [1, 3] and [2, 4] is [2, 3].)
//
//
//
//
// Example 1:
//
//
//
//
// Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
// Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//
//
//
//
// Note:
//
//
// 0 <= A.length < 1000
// 0 <= B.length < 1000
// 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
//
//
// Related Topics 双指针
// 👍 104 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
  public static void main(String[] args) {
    Solution solution = new IntervalListIntersections().new Solution();
    int A[][] = new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int B[][] = new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
    int[][] result = solution.intervalIntersection(A, B);
    for (int[] ans : result) {
      System.out.println(ans[0] + "," + ans[1]);
    }
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
      int[] a = new int[2], b = new int[2];
      List<int[]> results = new ArrayList<>();
      int p = 0, q = 0;
      while (p < A.length && q < B.length) {
        a[0] = A[p][0];
        a[1] = A[p][1];
        b[0] = B[q][0];
        b[1] = B[q][1];

        // 两个区间存在交集
        if (b[1] >= a[0] && a[1] >= b[0]) {
          results.add(new int[] {Math.max(a[0], b[0]), Math.min(a[1], b[1])});
        }
        //
        if (b[1] < a[1]) {
          q++;
        } else {
          p++;
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
