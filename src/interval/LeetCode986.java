package interval;

import java.util.ArrayList;
import java.util.List;

public class LeetCode986 {
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
      // 指针向前移动
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
