// Write an efficient algorithm that searches for a value in an m x n matrix. Thi
// s matrix has the following properties:
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previou
// s row.
//
//
//
// Example 1:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
// Output: true
//
//
// Example 2:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
// Output: false
//
//
// Example 3:
//
//
// Input: matrix = [], target = 0
// Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 0 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics 数组 二分查找
// 👍 266 👎 0

package com.shuzijun.leetcode.editor.cn;

public class SearchA2dMatrix {
  public static void main(String[] args) {
    Solution solution = new SearchA2dMatrix().new Solution();
    int matrix[][] = {
      {1, 3, 5, 7},
      {10, 11, 16, 20},
      {23, 30, 34, 50}
    };
    boolean flag = solution.searchMatrix(matrix, 3);
    System.out.println(flag);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix.length == 0) {
        return false;
      }
      int m = matrix.length;
      int n = matrix[0].length;
      int left = 0, right = m * n - 1;
      int mid, x, y;
      while (left <= right) {
        mid = ((right - left) >> 1) + left;
        x = mid / n;
        y = mid % n;
        if (matrix[x][y] == target) {
          return true;
        } else if (matrix[x][y] < target) {
          left = mid + 1;
        } else if (matrix[x][y] > target) {
          right = mid - 1;
        }
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
