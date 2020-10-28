package binary.search;

public class LeetCode35 {
  public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        right = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      }
    }
    return left;
  }
}
