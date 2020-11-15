package window;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeetCode76 {

  /**
   * 使用滑动窗口的模板来解决该问题，判断相等时必须使用equals不能使用==
   *
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();

    // init need
    for (char c : t.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }
    // define variable
    int left = 0, right = 0;
    int valid = 0;
    int len = Integer.MAX_VALUE, start = 0;

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

      while (valid == need.size()) {
        //update len
        if (right - left < len){
          start = left;
          len = right-left;
        }
        char d = s.charAt(left);
        left++;
        if (need.containsKey(d)){
          if (window.get(d).equals(need.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }

  /**
   * 官方给的解决思路
   */
  Map<Character, Integer> ori = new HashMap<Character, Integer>();
  Map<Character, Integer> cnt = new HashMap<Character, Integer>();
  public String minWindow2(String s, String t) {
    int tLen = t.length();
    for (int i = 0; i < tLen; i++) {
      char c = t.charAt(i);
      ori.put(c, ori.getOrDefault(c, 0) + 1);
    }
    int l = 0, r = -1;
    int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
    int sLen = s.length();
    while (r < sLen) {
      ++r;
      if (r < sLen && ori.containsKey(s.charAt(r))) {
        cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
      }
      while (check() && l <= r) {
        if (r - l + 1 < len) {
          len = r - l + 1;
          ansL = l;
          ansR = l + len;
        }
        if (ori.containsKey(s.charAt(l))) {
          cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
        }
        ++l;
      }
    }
    return ansL == -1 ? "" : s.substring(ansL, ansR);
  }

  public boolean check() {
    Iterator iter = ori.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry entry = (Map.Entry) iter.next();
      Character key = (Character) entry.getKey();
      Integer val = (Integer) entry.getValue();
      if (cnt.getOrDefault(key, 0) < val) {
        return false;
      }
    }
    return true;
  }
}
