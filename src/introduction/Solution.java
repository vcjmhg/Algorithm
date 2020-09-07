package introduction;

/** 字符串匹配问题 */
public class Solution {
  public static void main(String[] args) {
    System.out.println(kmp("hello", "ll"));
    System.out.println(kmp("hell", ""));
  }
  // 通过双重循环暴力解决问题，时间复杂度差不多是O(N*N)
  public static int subStr(String haystack, String needle) {
    if (haystack == "" || haystack == null) {
      return -1;
    }
    int i = 0, j = 0;
    // 转化成数组进行处理
    char hayStringArry[] = haystack.toCharArray();
    char needleArry[] = needle.toCharArray();
    for (i = 0; i <= hayStringArry.length - needleArry.length; i++) {
      for (j = 0; j < needleArry.length; j++) {
        if (hayStringArry[i + j] != needleArry[j]) {
          break;
        }
      }
      if (j == needle.length()) {
        return i;
      }
    }
    return -1;
  }
  // 常识用基本的字符串匹配算法
  public static int basicSubStr(String haystack, String needle) {
    if (haystack == null) {
      return -1;
    }
    char hayStackArry[] = haystack.toCharArray();
    char needleArry[] = needle.toCharArray();
    // 记录长度，减少length()函数的调用次数
    int hayStackLength = haystack.length();
    int needleLength = needle.length();
    int i = 0, j = 0;
    // i,j分别指向源字符串和目标字符
    while (i < hayStackLength && j < needleLength) {
      if (hayStackArry[i] == needleArry[j]) {
        i++;
        j++;
      } else {
        // 会退到下次进行匹配的字符串位置
        i = i - j + 1;
        // 从目标字符串的第一个位置开始进行匹配
        j = 0;
      }
    }
    if (j > needleLength - 1) {
      return i - needleLength;
    } else {
      return -1;
    }
  }
  // kmp算法
  public static int kmp(String haystack, String needle) {
    char[] needleArry = needle.toCharArray();
    char[] haystackArry = haystack.toCharArray();
    int needleLength = needle.length();
    int haystackLength = haystack.length();
    int[] next = getNext(needleArry);
    int i = 0, j = 0;
    while (i < haystackLength && j < needleLength) {
      if (haystackArry[i] == needleArry[j]) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }
    if (j > needleLength) {
      return i - needleLength;
    } else {
      return -1;
    }
  }
  // 生成next数组
  private static int[] getNext(char[] needleArry) {
    int next[] = new int[needleArry.length];
    next[0] = -1;
    int i = 0, j = -1;
    while (i < next.length) {
      if (j == -1 || needleArry[i] == needleArry[j]) {
        i++;
        j++;
        next[i] = j;
      } else {
        j = next[j];
      }
    }
    return next;
  }
}
