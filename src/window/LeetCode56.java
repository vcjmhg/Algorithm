package window;

import java.util.HashMap;
import java.util.Map;

public class LeetCode56 {
  
  /**
   * 按照标准模板使用滑动窗口方法来解决字符串排序问题
   * @param t
   * @param s
   * @return
   */
  public boolean checkInclusion(String t, String s) {
    if (t.length() > s.length()) {
      return false;
    }
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    // init need
    for (char c : t.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }
    // define variable
    int left = 0, right = 0;
    int valid = 0;
    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      // update right window
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (need.get(c).equals(window.get(c))) {
          valid++;
        }
      }
      // shrink left window
      // 每一次窗口的尺寸比need的尺寸大的时候都会进行瘦身操作,一直移动到比need的尺寸小1结束
      while (right - left >= t.length()) {
        if (valid == need.size()) {
          return true;
        }
        char d = s.charAt(left);
        left++;
        if (need.containsKey(d)) {
          if (window.get(d).equals(need.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }
    return false;
  }
}
