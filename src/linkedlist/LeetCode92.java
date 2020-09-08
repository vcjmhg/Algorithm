package linkedlist;

/** 翻转指定范围内的链表节点 */
public class LeetCode92 {
  public static void main(String[] args) {
    //
  }
  // 基本思路：移动到m处然后进行翻转再进行拼接
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) {
      return null;
    }
    ListNode plain = new ListNode(-1);
    plain.next = head;
    //		记录需要翻转的位置
    int num = 1;
    ListNode startBefore = null;
    // 移动到第m个节点
    while (num < m) {
      startBefore = head;
      head = head.next;
      num++;
    }
    // 记录开始的节点未知，便于后序拼接
    ListNode start = head;
    ListNode temp = null, pre = null;
    // 进行翻转
    while (num <= n) {
      temp = head.next;
      pre.next.next = pre;

      // 节点向前移动
      pre = head;
      head = temp;
    }

    // 进行拼接
    startBefore.next = pre;
    start.next = temp;
    return plain.next;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }
}
