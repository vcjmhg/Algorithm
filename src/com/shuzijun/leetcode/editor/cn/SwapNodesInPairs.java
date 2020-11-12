// Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes. Only nodes itself may be c
// hanged.
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]
//
//
// Example 2:
//
//
// Input: head = []
// Output: []
//
//
// Example 3:
//
//
// Input: head = [1]
// Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100
//
// Related Topics 链表
// 👍 735 👎 0

package com.shuzijun.leetcode.editor.cn;

public class SwapNodesInPairs {
  public static void main(String[] args) {
    Solution solution = new SwapNodesInPairs().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
   * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
   * this.next = next; } }
   */
  class Solution {
    public ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      // swap
      ListNode temp,nextHead;
      //save nextHead;
      nextHead = head.next.next;
      temp = head;
      head = head.next;
      head.next = temp;
      head.next.next = swapPairs(nextHead);
      return head;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

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
