package linkedlist;

/** 分割链表 */
public class LeetCode86 {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(2);
    l1.next.next.next.next = new ListNode(5);
    l1.next.next.next.next.next = new ListNode(2);

    Util.printList(partition(l1, 4));
  }

  /**
   * 将大于x的节点放到一张新的链表中，并将该节点在原来链表中删除，最终连接两个链表。该方法空间复杂度比较高 当头结点不确定的情况下我们可以考虑使用哑巴节点
   *
   * @param head
   * @param x
   * @return
   */
  public static ListNode partition(ListNode head, int x) {
    ListNode bigValueList = new ListNode(0);
    ListNode bigCurrent = bigValueList;
    ListNode pre = new ListNode(0);
    pre.next = head;
    // 增加一个头结点
    ListNode headNode = pre;
    // 将大于x的节点放到bigValueList中
    while (head != null) {
      while (head != null && head.val >= x) {
        bigCurrent.next = head;
        pre.next = head.next;

        bigCurrent = bigCurrent.next;
        head = head.next;
      }
      // 节点向后移动,注意做边界判断，处理head为空的情况
      if (head != null) {
        pre = head;
        head = head.next;
      }
    }
    // 两个链表进行拼接
    bigCurrent.next = null;
    pre.next = bigValueList.next;
    return headNode.next;
  }
}
