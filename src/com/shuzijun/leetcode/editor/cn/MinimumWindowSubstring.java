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
// 👍 829 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
  public static void main(String[] args) {
    Solution solution = new MinimumWindowSubstring().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
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
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
