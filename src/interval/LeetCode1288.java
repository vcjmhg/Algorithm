package interval;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1288 {
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
