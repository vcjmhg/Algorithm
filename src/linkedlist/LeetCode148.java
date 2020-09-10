package linkedlist;

/** 链表排序问题 思路： 通过归并排序来实现来实现链表的排序问题。在合并的时候有两种思路一种是通过迭代来进行合并，另一种是通过递归来实现合并。 */
public class LeetCode148 {
  public static void main(String[] args) {
    ListNode l1 = Util.initNodeList(new int[] {4, 2, 1, 3, 7, 2});
    //    Util.printList(l1);
    Util.printList(mergesort(l1));
  }
  // 使用归并算法进行链表排序
  public static ListNode mergesort(ListNode head) {
    // 如果链表只有一个节点直接返回
    if (head == null || head.next == null) {
      return head;
    }
    // 找到链表的中间节点
    ListNode middle = findMiddle(head);
    // 获取后半段的链表节点,同时与前半段节点断开
    ListNode tail = middle.next;
    middle.next = null;

    // 对左侧进行排序
    ListNode left = mergesort(head);
    // 对右侧进行排序
    ListNode right = mergesort(tail);
    // 合并两条链,注意是将left和right进行合并
    ListNode result = merge(left, right);
    return result;
  }
  // 将两个有序链表进行合并
  private static ListNode merge(ListNode left, ListNode right) {
    ListNode headNode = new ListNode(0);
    ListNode tail = headNode;
    headNode.next = left;

    while (left != null && right != null) {
      if (left.val < right.val) {
        tail.next = left;
        left = left.next;
      } else {
        tail.next = right;
        right = right.next;
      }
      tail = tail.next;
    }

    // 将非空的节点直接链接到temp后边
    if (left != null) {
      tail.next = left;
    }
    if (right != null) {
      tail.next = right;
    }
    return headNode.next;
  }

  // 寻找链表的中间节点，可以使用快慢指针
  private static ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      // 快指针一次走两步
      fast = fast.next.next;
      // 慢指针一次走一步
      slow = slow.next;
    }
    return slow;
  }
}
