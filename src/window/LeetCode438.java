package window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode438 {
  /**
   * 使用滑动窗口思想解决子串问题
   * @param s
   * @param p
   * @return
   */
  public List<Integer> findAnagrams(String s, String p) {
    // border case
    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length()) {
      return result;
    }
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    // init need
    for (char c : p.toCharArray()) {
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
      while (right - left >= p.length()) {
        if (valid == need.size()) {
          result.add(left);
        }
        char d = s.charAt(left);
        left++;
        if (need.containsKey(d)) {
          if (need.get(d).equals(window.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }
    return result;
  }
}
