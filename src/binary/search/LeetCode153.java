package binary.search;

public class LeetCode153 {
  /**
   * 使用二分搜索解决寻找旋转排序数组中的最小值 基本思路：
   * 在二分查找的过程中比较最左侧和最右侧值的大小，如果右侧小，则搜索【mid+1,right】区间，同时要注意一种情况，就是mid隔开了最小值，
   * 因此需要判断mid位置元素是否是最小的元素，如果不是将搜索区间改成【left，mid-1】。 如果左侧小则直接搜索【left，mid-1】
   *
   * @param nums
   * @return
   */
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    int min = nums[left];
    while (left <= right) {
      int mid = ((right - left) >> 1) + left;
      if (nums[mid] < min) {
        min = nums[mid];
      }
      if (nums[left] < nums[right]) {
        right = mid - 1;
      } else if (nums[left] > nums[right]) {
        // 证明最小值在mid的前面
        if (mid > left && nums[mid] > nums[mid - 1]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[left] == nums[right]) {
        return min;
      }
    }
    return min;
  }
}
