package linkedlist;

/** 删除有序链表中重复字符串问题 */
public class LeetCode206 {
  public static void main(String[] args) {
    // 1 1 2
    ListNode testList1 = new ListNode();
    testList1.next = new ListNode(1);
    testList1.next.next = new ListNode(1);
    testList1.next.next.next = new ListNode(2);
    //    printList(testList1);
    printList(deleteDuplicates(testList1));
  }

  /**
   * 给定一个链表删除其重复的节点
   *
   * @param head
   * @return
   */
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    current = current.next;
    while (current != null) {
      while (current.next != null && current.val == current.next.val) {
        current.next = current.next.next;
      }
      current = current.next;
    }
    return head;
  }

  // 定义链表结构
  static class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    // 定义构造方法
    ListNode(int val) {
      this.val = val;
    }
  }

  private static void printList(ListNode head) {
    ListNode current = head;
    if (current == null) {
      return;
    }
    current = current.next;
    while (current != null) {
      System.out.print(" " + current.val);
      current = current.next;
    }
  }
}
