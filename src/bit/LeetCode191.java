package bit;

public class LeetCode191 {
  public int hammingWeight(int n) {
    int num = 0;
    while (n != 0) {
      n = n & (n - 1);
      num++;
    }
    return num;
  }
}
