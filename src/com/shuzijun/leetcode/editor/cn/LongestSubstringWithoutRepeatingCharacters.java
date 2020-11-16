// Given a string s, find the length of the longest substring without repeating c
// haracters.
//
//
// Example 1:
//
//
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
//
//
// Example 2:
//
//
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
//
// Example 3:
//
//
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a
// substring.
//
//
// Example 4:
//
//
// Input: s = ""
// Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4587 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    String s = "pwwkew";
    int ans = solution.lengthOfLongestSubstring(s);
    System.out.println(ans);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
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
  // leetcode submit region end(Prohibit modification and deletion)

}
