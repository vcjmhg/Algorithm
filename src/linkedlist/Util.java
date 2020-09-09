package linkedlist;

/** 链表在刷题过程中的常用的一些工具方法 */
public class Util {
  /**
   * 打印链表节点值
   *
   * @param head
   */
  public static void printList(ListNode head) {
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

class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}
