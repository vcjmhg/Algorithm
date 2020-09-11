package linkedlist;

/**
 * 判断链表中是否有环
 * 基本思路：通过快慢指针来解决。快指针每次会比慢指针多走一格
 */
public class LeetCode141 {
  public static void main(String[] args) {
    ListNode l1 = Util.initNodeList(new int[]{1,2,4,3});
    System.out.println(hasCycle(l1));
  }

    /**
     * 使用快慢指针来解决链表是否有环的判断
     * @param head
     * @return
     */
  public static boolean hasCycle(ListNode head){
    //边界情况处理
    if (head ==null || head.next ==null){
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    boolean hasCycle = false;
    while (fast != null && fast.next != null){
        //如果两个指针重逢则证明一定有环
        if (fast == slow){
            hasCycle = true;
            break;
        }
        //slow指针每次走一步，fast指针每次走两步
        slow = slow.next;
        fast = fast.next.next;
    }
    return hasCycle;
  }

}
