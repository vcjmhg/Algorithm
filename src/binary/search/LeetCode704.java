package binary.search;

public class LeetCode704 {
  /**
   * 基本二分查找，查找某一个数的具体位置
   *
   * @param nums
   * @param target
   * @return
   */
  public int binarySearch(int[] nums, int target) {
    // 初始化，细节一：right此处复制为nums.length - 1
    int left = 0, right = nums.length - 1;
    // 循环退出条件，细节二：由于细节一的原因，此处要使用left<=right，从而保证能够搜索到right的位置
    while (left <= right) {
      // 计算中值
      int mid = left + (right - left) / 2;
      // 查找到目标结果直接返回对应索引的位置
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        // 细节三：因为已经验证过mid位置，因此需要从【mid+1，right】区间开始查找
        left = mid + 1;
      } else if (nums[mid] > target) {
        // 细节四：原因同细节三
        right = mid - 1;
      }
    }
    // 区间内所有值都已搜索完毕，直接返回-1
    return -1;
  }
}
