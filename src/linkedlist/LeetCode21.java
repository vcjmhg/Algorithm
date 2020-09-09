package linkedlist;

/** 合并两个有序的链表 思路：通过双指针发来解决 */
public class LeetCode21 {
  public static void main(String[] args) {
    // 1 1 2
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);
    l2.next.next.next = new ListNode(5);
    Util.printList(mergeTwoListsByReCursion(l1, l2));
  }
  // 合并两个有序链表
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode plainNode = new ListNode(0);
    ListNode temp = plainNode;
    // 边比较边合并
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    if (l1 != null) {
      temp.next = l1;
    }
    if (l2 != null) {
      temp.next = l2;
    }
    return plainNode.next;
  }
  // 基本思路其实就是在每层递归只处理一个节点
  public static ListNode mergeTwoListsByReCursion(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
}
