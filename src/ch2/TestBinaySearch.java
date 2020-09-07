package ch2;

public class TestBinaySearch {
  public static void main(String[] args) {
    int data[] = {0, 1, 2, 3, 4, 5};
    System.out.println(binarySearch(data, 2));
  }

  public static int binarySearch(int data[], int value) {
    int low = 0, high = data.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (data[mid] < value) {
        low = mid + 1;
      } else if (data[mid] > value) {
        high = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
