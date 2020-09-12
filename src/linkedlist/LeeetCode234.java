package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个链表是不是回文链表
 */
public class LeeetCode234 {
  public static void main(String[] args) {
    ListNode l1 = Util.initNodeList(new int[]{1,2});
    System.out.println(isPalindromeBySlowAndFast(l1));
  }

    /**
     * 最容易想到的是将其放到容器中，然后采用类似与双端队列的思想来进行解决
     * @param head
     * @return
     */
  public static boolean isPalindrome(ListNode head){
      //边界情况处理，在只有一个节点或者是空节点的时候直接返回true
      if (head == null || head.next == null){
          return true;
      }
      //放到ArrayList中便于采用双指针来进行处理
      List<ListNode> nodeList = new ArrayList<>();
      while (head !=null){
          nodeList.add(head);
          head = head.next;
      }
      //采用双指针的思路从两端同时开始处理
      int i = 0, j =nodeList.size()-1;
      while (i < j){
          // 在节点个数是奇数的情况下i和j可能相等
          if (i == j){
              return true;
          }
          if (nodeList.get(i).val != nodeList.get(j).val){
              return false;
          }else {
              i++;
              j--;
          }
      }
      return true;
  }
  //第二种比较容易想的方法是通过快慢指针来寻找链表中点，然后通过链表倒置后再次进行比较
    public static boolean isPalindromeBySlowAndFast(ListNode head){
//        边界情况判断
        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow在while循环结束的时刻指向的是中间节点的前一个节点,根据slow和后续节点的关系，判断断链的位置
        //证明可能是偶数个节点的回文链，断链位置应该是slow.next
        ListNode newList =null;
        if(slow.val == slow.next.val){
            newList = reverse(slow.next);
            //将第一个链和第二个链断开
            slow.next = null;
            //如果是奇数个节点,直接指向了中间节点
        }else {
            newList = reverse(slow.next);
            slow = null;
        }
        //比较两个链的节点是否相等
        while (head !=null && newList !=null){
            if (head.val != newList.val){
                return false;
            }else {
                head = head.next;
                newList = newList.next;
            }
        }
        return true;
    }
    //将链表进行转置
    private static ListNode reverse(ListNode head) {
      //边界情况处理
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre=null,temp;
        while (head !=null){
            temp = head.next;
            head.next = pre;

            pre =head;
            head =temp;
        }
        return pre;
    }
}
