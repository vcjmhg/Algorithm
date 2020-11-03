package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
  public int intervalSchedule(int[][] intvs) {
    if (intvs.length == 0) {
      return 0;
    }
    // sort
    Arrays.sort(
        intvs,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[2];
          }
        });
    //至少可以有一个任务
    int count = 1;
    int x_end = intvs[0][1];
    for (int[] interval : intvs) {
      int start = interval[0];
      //找到下一个满足要求的区间
      if (start >= x_end) {
        count++;
        x_end = interval[1];
      }
    }
    return count;
  }
}
