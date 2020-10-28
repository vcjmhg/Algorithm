package binary.search;

public class Util {
  public static void main(String[] args) {
    Util solution = new Util();
    int[] nums = new int[] {1, 2, 2, 3};
    int index = solution.rightBound(nums, 2);
    System.out.println(index);
  }
  /**
   * 基本二分查找，查找某一个数的具体位置
   *
   * @param nums
   * @param target
   * @return
   */
  public int binarySearch(int[] nums, int target) {
    // 初始化，细节1：right此处复制为nums.length - 1
    int left = 0, right = nums.length - 1;
    // 细节2：循环退出条件，由于细节1的原因，此处要使用left<=right，从而保证能够搜索到right的位置
    while (left <= right) {
      // 计算中值
      int mid = left + (right - left) / 2;
      // 查找到目标结果直接返回对应索引的位置
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        // 细节3：因为已经验证过mid位置，因此需要从【mid+1，right】区间开始查找
        left = mid + 1;
      } else if (nums[mid] > target) {
        // 细节4：原因同细节三
        right = mid - 1;
      }
    }
    // 区间内所有值都已搜索完毕，直接返回-1
    return -1;
  }

  /**
   * 寻找左边界
   *
   * @param nums
   * @param target
   * @return
   */
  public int leftBound(int[] nums, int target) {
    // 细节1：right赋值为length，意味着搜索区间范围左闭右开
    int left = 0, right = nums.length;
    // 细节2
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        // 细节3
        right = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        // 细节4
        right = mid;
      }
    }
    // 细节5
    return nums[left] == target ? left : -1;
  }

  public int rightBound(int[] nums, int target) {
    int left = 0, right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        //细节1
        left = mid + 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      }
    }
    //细节2
    return nums[left - 1] == target ? left - 1 : -1;
  }
}
