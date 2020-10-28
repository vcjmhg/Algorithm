// Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.
//
// Example 1:
//
//
// Input: [3,4,5,1,2]
// Output: 1
//
//
// Example 2:
//
//
// Input: [4,5,6,7,0,1,2]
// Output: 0
//
// Related Topics 数组 二分查找
// 👍 280 👎 0

package com.shuzijun.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArray {
  public static void main(String[] args) {
    Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findMin(int[] nums) {
      int left = 0, right = nums.length - 1;
      int min = nums[left];
      while (left <= right) {
        int mid = ((right - left) >> 1) + left;
        if (nums[mid] < min) {
          min = nums[mid];
        }
        if (nums[left] < nums[right]) {
          right = mid - 1;
        } else if (nums[left] > nums[right]) {
          if (mid > left && nums[mid] > nums[mid - 1]) {
            left++;
          } else {
            left = mid + 1;
          }
        } else if (nums[left] == nums[right]) {
          return min;
        }
      }
      return min;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
