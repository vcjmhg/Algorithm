package binary.search;

public class LeetCode74 {
  /**
   * 将二维矩阵映射成一维矩阵，然后通过二分查找来解决该问题
   * @param matrix
   * @param target
   * @return
   */
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
