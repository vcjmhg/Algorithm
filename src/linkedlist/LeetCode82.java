package linkedlist;

/** 反转链表 */
public class LeetCode82 {
  public static void main(String[] args) {
    // 1 1 2
    ListNode testList1 = new ListNode(3);
    testList1.next = new ListNode(1);
    testList1.next.next = new ListNode(1);
    testList1.next.next.next = new ListNode(2);

    printList(reverseListByRecursion(testList1));
  }
  // 对链表进行翻转
  public static ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode temp;
    while (head != null) {
      temp = head.next;
      head.next = pre;

      // pre与head向前移动
      pre = head;
      head = temp;
    }
    return pre;
  }
  // 使用递归方法解决该问题
  public static ListNode reverseListByRecursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = reverseListByRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return cur;
  }

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

class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}
