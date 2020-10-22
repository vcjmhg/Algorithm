package stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** 打开锁转盘 */
public class LeetCode752 {
  public static void main(String[] args) {
    //
  }

  public int openLock(String[] deadends, String target) {
    // 记录需要跳过的deadends信息
    Set<String> deadSet = new HashSet<>();
    for (String deadStr : deadends) {
      deadSet.add(deadStr);
    }
    int step = 0;
    // 标记已经访问的字符
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add("0000");
    visited.add("0000");

    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        String cur = queue.poll();
        // meet deadSet
        if (deadSet.contains(cur)) {
          continue;
        }
        // find target
        if (target.equals(cur)) {
          return step;
        }
        // visit other neighbors
        for (int j = 0; j < 4; j++) {
          String up = plusUp(cur, j);
          if (!visited.contains(up)) {
            visited.add(up);
            queue.add(up);
          }
          String down = plusDown(cur,j);
          if (!visited.contains(down)){
            visited.add(down);
            queue.add(down);
          }
        }
      }
      step ++;
    }
    return -1;
  }

  private String plusUp(String str, int j) {
    char[] strArray = str.toCharArray();
    if (strArray[j] == '9') {
      strArray[j] = '0';
    } else {
      strArray[j] += 1;
    }
    return new String(strArray);
  }

  private String plusDown(String str, int j) {
    char[] strArray = str.toCharArray();
    if (strArray[j] == '0') {
      strArray[j] = '9';
    } else {
      strArray[j] -= 1;
    }
    return new String(strArray);
  }
}
