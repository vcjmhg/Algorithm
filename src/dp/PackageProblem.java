package dp;

import java.nio.file.Path;

public class PackageProblem {
  public static void main(String[] args) {
    PackageProblem solution = new PackageProblem();
    int N = 3, W = 4;
    int[] wt = {2, 1, 3};
    int[] val = {4, 2, 3};
    int ans = solution.zeroOnePackage(W, N, wt, val);
    System.out.println(ans);
  }

  public int zeroOnePackage(int W, int N, int[] wt, int[] val) {
    int[][] dp = new int[N + 1][W + 1];

    for (int i = 1; i < N + 1; i++) {
      for (int w = 1; w < W + 1; w++) {
        if (w - wt[i - 1] < 0) {
          // 当前容量装不下，不能装该背包
          dp[i][w] = dp[i - 1][w];
        } else {
          // 在能够装包的情况下有两种选择，第一种不装dp[i-1][w]，
          // 第二种装，此时剩余的包容量会变成w-wt【i-1】，获取价值为val【i-1】
          dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
        }
      }
    }
    return dp[N][W];
  }
}
