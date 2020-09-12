package linkedlist;

import java.util.ArrayList;
import java.util.List;

/** 按照要求重排链表 */
public class LeetCode143 {
  public static void main(String[] args) {
    ListNode l1 = Util.initNodeList(new int[] {1, 2, 3, 4, 5});
    //    Util.printList(reverse(l1));
    reorderListByRecursion(l1);
    Util.printList(l1);
  }

  /** 按照要求重新对链表进行排序: 给定链表 1->2->3->4, 重新排列为 1->4->2->3. */
  public static void reorderList(ListNode head) {
    // 边界情况进行处理，如果只有一个节点或者节点为空，直接返回
    if (head == null || head.next == null) {
      return;
    }
    // 如果只有一个节点直接反掌结果
    if (head == null || head.next == null) {
      return;
    }
    ListNode headNode = new ListNode(0);
    headNode.next = head;
    // 获取中间链表节点
    ListNode middle = getMiddle(head);
    ListNode tail = middle.next;
    middle.next = null;
    // 对后一半的链表进行翻转
    tail = reverse(tail);
    ListNode temp = headNode;
    // 将两段链表交替连接
    while (head != null && tail != null) {
      temp.next = head;
      head = head.next;
      temp = temp.next;

      temp.next = tail;
      tail = tail.next;
      temp = temp.next;
    }
    // 非空节点连接到链表末尾
    if (head != null) {
      temp.next = head;
    }
    if (tail != null) {
      temp.next = tail;
    }
  }
  // 对链表进行翻转
  private static ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode temp;
    while (head != null) {
      temp = head.next;
      // 此处应该通过head的next来实现翻转
      head.next = pre;
      pre = head;
      head = temp;
    }
    return pre;
  }

  // 获取链表的中间节点
  private static ListNode getMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  /**
   *  使用存储解决该问题
   *  基本思路：将链表转换乘ArraryList类型然后从后向前来进行遍历
   * @param head
   */
  public static void reorderListByStorage(ListNode head) {
    //边界情况处理
    if(head == null || head.next == null){
      return;
    }
    //将链表转换乘ArrayList进行操作
    ArrayList<ListNode> list = new ArrayList<ListNode>();
    while (head != null){
      list.add(head);
      head = head.next;
    }
    //通过双指针连接乘新的链表
    int i=0,j=list.size()-1;
    while (i<j){
      list.get(i).next = list.get(j);
      i++;
      //边界情况处理 i == j
      if(i == j){
        break;
      }
      list.get(j).next=list.get(i);
      j--;
    }
    //将最后一个节点的next置空
    list.get(i).next = null;
  }

  // 使用递归解决该问题
  public static void reorderListByRecursion(ListNode head){
    //边界情况处理，对长度小于2的情况直接返回
    if (head == null || head.next == null || head.next.next == null){
      return;
    }
    ListNode current = head;
    int len=0;
    //计算链表长度
    while (current != null){
      len++;
      current = current.next;
    }

    // 对链表进行递归处理
    reorderListHelper(head, len);

  }

  /**
   * 对一个链表进行递归处理
   * @param head
   * @param len
   */
  private static ListNode reorderListHelper(ListNode head, int len) {
    //递归终止条件,必须要对返回的next进行设置
    if (len == 1){
      ListNode outTail = head.next;
      head.next = null;
      return outTail;
    }
    if (len == 2){
      ListNode outTail = head.next.next;
      head.next.next = null;
      return outTail;
    }
    //得到对应的尾节点。在递归的每一层处理了第一个节点和最后一个节点，并且返回最后一个节点的下一个节点即新的末尾节点
    ListNode tail = reorderListHelper(head.next,len-2);
    ListNode subHead = head.next;
    //获取tial节点的下一个节点作为末尾节点
    ListNode outTail = tail.next;
    head.next = tail;
    tail.next = subHead;
    return outTail;
  }

}
