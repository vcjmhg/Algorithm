package linkedlist;

/** 翻转指定范围内的链表节点 */
public class LeetCode92 {
  public static void main(String[] args) {
    // 1 1 2
    ListNode testList1 = new ListNode(1);
    testList1.next = new ListNode(2);
    testList1.next.next = new ListNode(3);
    testList1.next.next.next = new ListNode(4);

    printList(reverseBetween(testList1, 1, 4));
  }
  // 基本思路：移动到m处然后进行翻转再进行拼接
  public static ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) {
      return null;
    }
    ListNode plain = new ListNode(-1);
    plain.next = head;
    // 记录需要翻转的位置
    int num = 1;
    ListNode startBefore = plain;
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
      num++;
      temp = head.next;
      head.next = pre;
      // 节点向前移动
      pre = head;
      head = temp;
    }

    // 进行拼接
    startBefore.next = pre;
    start.next = temp;
    return plain.next;
  }

  // 打印节点内容
  private static void printList(ListNode head) {
    ListNode current = head;
    if (current == null) {
      return;
    }
    while (current != null) {
      System.out.print(" " + current.val);
      current = current.next;
    }
  }
}
