package recursive;

public class LeetCode24 {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // swap
    ListNode temp, nextHead;
    // save nextHead;
    nextHead = head.next.next;
    temp = head;
    head = head.next;
    head.next = temp;
    head.next.next = swapPairs(nextHead);
    return head;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
