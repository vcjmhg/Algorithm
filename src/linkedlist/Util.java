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
  // 将数组初始化成链表
  public static ListNode initNodeList(int a[]) {
    ListNode headNode = new ListNode(0);
    ListNode temp = headNode, newNode = null;
    for (int i = 0; i < a.length; i++) {
      newNode = new ListNode(a[i]);
      temp.next = newNode;
      temp = temp.next;
    }
    return headNode.next;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}
