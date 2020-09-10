package introduction;

/** 字符串匹配问题 */
public class Solution {
  public static void main(String[] args) {
    //    System.out.println(sunday("hello", "ll"));
    //    System.out.println(sunday("hell", ""));
    //    System.out.println(sunday("aaaa", "bba"));
    System.out.println(sunday("a", "b"));

    System.out.println(sunday("aabaaabaaac", "aabaaac"));
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
      if (j == -1 || haystackArry[i] == needleArry[j]) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }
    if (j > needleLength - 1) {
      return i - needleLength;
    } else {
      return -1;
    }
  }
  // 生成next数组
  private static int[] getNext(char[] needleArry) {
    int next[] = new int[needleArry.length + 1];
    next[0] = -1;
    int i = 0, j = -1;
    while (i < needleArry.length) {
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
  // 使用sunday算法来求解
  public static int sunday(String haystack, String needle) {
    // 边界情况
    if (haystack == null) {
      return -1;
    }
    if (needle.equals("") || needle == null) {
      return 0;
    }
    // 转数组
    char[] haystackArry = haystack.toCharArray();
    char[] needleArry = needle.toCharArray();
    int haystackLength = haystack.length();
    int needleLength = needle.length();

    // 求解偏移数组，偏移数组的大小应该是ascii_size的范围
    int[] move = new int[126];
    for (int i = 0; i < 126; i++) {
      move[i] = needleLength + 1;
    }
    // 从左向右扫描，needle字符中存在的字符对应位置的值等于当前字符到最优一个字符的距离+1
    for (int i = 0; i < needleLength; i++) {
      move[needleArry[i]] = needleLength - i;
    }
    // 进行匹配,其中s指向模式字符串第一个字符所在的源字符串的位置。j表示当前匹配成功的字符
    int s = 0, j = 0;
    while (s <= haystackLength - needleLength) {
      // 每次进行新一轮匹配的时候j都要置零
      j = 0;
      while (haystackArry[s + j] == needleArry[j]) {
        j++;
        if (j >= needleLength) {
          return s;
        }
      }
      // 失配情况下对s进行跳转
      if (s < haystackLength - needleLength) {
        s += move[haystackArry[s + needleLength]];
      } else {
        return -1;
      }
      //      s += move[haystackArry[s + needleLength]];
    }
    return -1;
  }
}
