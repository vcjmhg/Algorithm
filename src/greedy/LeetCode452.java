package greedy;

import java.util.Arrays;

public class LeetCode452 {
  public int findMinArrowShots(int[][] points) {
    if (points.length <= 0) {
      return 0;
    }
    // 在排序的过程中要考虑溢出情况的发生
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    int count = 1;
    int x_end = points[0][1];
    for (int[] point : points) {
      if (point[0] > x_end) {
        count++;
        x_end = point[1];
      }
    }
    return count;
  }
}
