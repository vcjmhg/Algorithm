package linkedlist;

public class LeetCode201 {
  /**
   * 使用最暴力方法，从m到n按位进行与运算
   * @param m
   * @param n
   * @return
   */
  public int rangeBitwiseAnd(int m, int n) {
    // m 要赋值给 i，所以提前判断一下
    if (m == Integer.MAX_VALUE) {
      return m;
    }
    int res = m;
    for (int i = m + 1; i <= n; i++) {
      res &= i;
      if (res == 0 || i == Integer.MAX_VALUE) {
        break;
      }
    }
    return res;
  }
}
