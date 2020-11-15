// Given two strings s and t, return the minimum window in s which will contain a
// ll the characters in t. If there is no such window in s that covers all characte
// rs in t, return the empty string "".
//
// Note that If there is such a window, it is guaranteed that there will always
// be only one unique minimum window in s.
//
//
// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 105
// s and t consist of English letters.
//
//
//
// Follow up: Could you find an algorithm that runs in O(n) time? Related Topics
// 哈希表 双指针 字符串 Sliding Window
// 👍 825 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinimumWindowSubstring {
  public static void main(String[] args) {
    Solution solution = new MinimumWindowSubstring().new Solution();
    String s = "ADOBECODEBANC";
    String t = "ABC";
    String result = solution.minWindow(s, t);

    System.out.println(result);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
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
