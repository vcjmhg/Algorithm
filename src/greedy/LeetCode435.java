package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode435 {
  /**
   * 使用贪心算法解决区间重叠个数问题 
   * 贪心思路： 
   * 1. 从区间集合中选择一个区间x，这个x是所有区间中结束最早的（end最小）。 
   * 2. 把所有与x区间相交的区间从区间集合中删除掉。 
   * 3.重复1和2，直到区间集合为空。之前选出的那些x的集合就是最大的不想交子集。
   * @param intervals
   * @return
   */
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
          }
        });

    int count = 1;
    int x_end = intervals[0][1];
    for (int[] interval : intervals) {
      if (interval[0] >= x_end) {
        count++;
        x_end = interval[1];
      }
    }
    return intervals.length - count;
  }
}
