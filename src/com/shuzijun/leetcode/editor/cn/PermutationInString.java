// Given two strings s1 and s2, write a function to return true if s2 contains th
// e permutation of s1. In other words, one of the first string's permutations is t
// he substring of the second string.
//
//
//
// Example 1:
//
//
// Input: s1 = "ab" s2 = "eidbaooo"
// Output: True
// Explanation: s2 contains one permutation of s1 ("ba").
//
//
// Example 2:
//
//
// Input:s1= "ab" s2 = "eidboaoo"
// Output: False
//
//
//
// Constraints:
//
//
// The input strings only contain lower case letters.
// The length of both given strings is in range [1, 10,000].
//
// Related Topics 双指针 Sliding Window
// 👍 194 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
  public static void main(String[] args) {
    Solution solution = new PermutationInString().new Solution();
    String t = "hello";
    String s = "ooolleoooleh";
    boolean ans = solution.checkInclusion(t, s);
    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
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
  // leetcode submit region end(Prohibit modification and deletion)

}
