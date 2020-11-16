// Given a string s and a non-empty string p, find all the start indices of p's a
// nagrams in s.
//
// Strings consists of lowercase English letters only and the length of both str
// ings s and p will not be larger than 20,100.
//
// The order of output does not matter.
//
// Example 1:
//
// Input:
// s: "cbaebabacd" p: "abc"
//
// Output:
// [0, 6]
//
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//
//
// Example 2:
//
// Input:
// s: "abab" p: "ab"
//
// Output:
// [0, 1, 2]
//
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
//
// Related Topics 哈希表
// 👍 409 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.*;

public class FindAllAnagramsInAString {
  public static void main(String[] args) {
    Solution solution = new FindAllAnagramsInAString().new Solution();
    String s = "cbaebabacd";
    String p = "abc";
    System.out.println(solution.findAnagrams(s,p));
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
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
  // leetcode submit region end(Prohibit modification and deletion)

}
