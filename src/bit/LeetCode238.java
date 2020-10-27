package bit;

public class LeetCode238 {
  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      result[i] = getCount(i);
    }
    return result;
  }
  // count the num of 1
  private int getCount(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }
}
