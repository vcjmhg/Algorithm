package window;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
  /**
   * 使用滑动窗口思想解决无重复字符的最长子串问题
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> window = new HashMap<>();
    // define variable
    int left = 0, right = 0;
    int result = 0;
    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      window.put(c, window.getOrDefault(c, 0) + 1);

      while (window.getOrDefault(c, 0) > 1) {
        char d = s.charAt(left);
        left++;
        window.put(d, window.get(d) - 1);
      }
      result = Math.max(result, right - left);
    }
    return result;
  }
}
