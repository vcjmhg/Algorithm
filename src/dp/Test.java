package dp;

import java.util.HashMap;
import java.util.Map;

public class Test {
  public static void main(String[] args) {
<<<<<<< HEAD
    int result = new Test().fibWihtDp2(45);
=======
    int result = new Test().fibWihtDp2(8);
>>>>>>> 72e947e2533d6f6adb8e24eeb68e7f7cb680dbfe

    System.out.println(result);
  }

  public int fib(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }
    return fib(n - 1) + fib(n - 2);
  }

  public int fibWithMemo(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
    map.put(2, 1);
    return helper(map, n);
  }

  private int helper(Map<Integer, Integer> map, int n) {
    // if memo has value ,return it
    if (map.containsKey(n)) {
      return map.get(n);
    }
    // memo no the value, add it to memo
    int result = helper(map, n - 1) + helper(map, n - 2);
    map.put(n, result);

    return result;
  }

  public int fibWithDP(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public int fibWihtDp2(int n) {
<<<<<<< HEAD
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int pre = 0, cur = 1;
    int sum = 0;
    for (int i = 2; i <= n; i++) {
      sum = (pre + cur);
=======
    int pre = 1, cur = 1;
    int sum = 0;
    for (int i = 3; i < n + 1; i++) {
      sum = pre + cur;
>>>>>>> 72e947e2533d6f6adb8e24eeb68e7f7cb680dbfe
      pre = cur;
      cur = sum;
    }
    return cur;
  }
}
