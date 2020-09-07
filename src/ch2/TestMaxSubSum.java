package ch2;

public class TestMaxSubSum {
  public static void main(String[] args) {
    int a1[] = new int[] {4, -3, 5, -2, -1, 2, 6, -2};
    System.out.println(maxSubSum3(a1, 0, a1.length - 1));
    System.out.println(maxSubSum4(a1, 0, a1.length - 1));
  }
  // 分治思想来解决
  public static int maxSubSum3(int a[], int left, int right) {
    // base case
    if (left == right) {
      if (a[left] > 0) {
        return a[left];
      } else {
        return 0;
      }
    }

    // center计算方式可以优化
    int center = (left + right) / 2;
    int maxLeftSum = maxSubSum3(a, left, center);
    int maxRightSum = maxSubSum3(a, center + 1, right);

    int leftBorderSum = 0, maxLeftBorderSum = 0;
    for (int i = center; i >= left; i--) {
      leftBorderSum += a[i];
      if (leftBorderSum > maxLeftBorderSum) {
        maxLeftBorderSum = leftBorderSum;
      }
    }
    int rightBorderSum = 0, maxRightBorderSum = 0;
    for (int i = center + 1; i <= right; i++) {
      rightBorderSum += a[i];
      if (rightBorderSum > maxRightBorderSum) {
        maxRightBorderSum = rightBorderSum;
      }
    }
    return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
  }

  private static int max3(int v1, int v2, int v3) {
    if (v1 > v2) {
      return v1 > v3 ? v1 : v3;
    } else {
      return v2 > v3 ? v2 : v3;
    }
  }
  // 最优的解决方法
  public static int maxSubSum4(int a[], int left, int right) {
    int maxSum = 0, thisSum = 0;
    for (int i = 0; i < a.length; i++) {
      thisSum += a[i];
      if (thisSum > maxSum) {
        maxSum = thisSum;
      } else if (thisSum < 0) {
        thisSum = 0;
      }
    }
    return maxSum;
  }
}
