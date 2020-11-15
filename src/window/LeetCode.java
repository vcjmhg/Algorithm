package window;

import java.util.HashMap;
import java.util.Map;

public class LeetCode {
  
  /**
   * 使用滑动窗口的模板来解决该问题，可能会有溢出的情况发生
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

    char[] s_array = s.toCharArray(), t_array = t.toCharArray();
    for (char c : t_array) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    /* 已经和need匹配的字符串个数*/ int valid = 0;
    //
    int start = 0, len = Integer.MAX_VALUE;

    while (right < s.length()) {
      //
      char c = s_array[right];
      // move to right
      right++;
      // update the data of window
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        // 有一些疑问
        if (window.get(c).equals(need.get(c))) {
          valid++;
        }
      }
      // 判断右侧是否需要收缩
      while (valid == need.size()) {
        // 更新最小覆盖串
        if (right - left < len) {
          start = left;
          len = right - left;
        }
        // d是即将被移出窗口的字符
        char d = s_array[left];
        // left右移
        left++;
        // update the date of window
        if (need.containsKey(d)) {
          if (window.get(d) == need.get(d)) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }
}
