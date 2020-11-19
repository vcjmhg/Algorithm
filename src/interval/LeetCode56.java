package interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class LeetCode56 {
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
