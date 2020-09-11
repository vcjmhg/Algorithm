package linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 判断链表是否有环，并且返回如环的第一个节点
 */
public class LeetCode142 {
    public static void main(String[] args) {
        ListNode l1 = Util.initNodeList(new int[]{1,2,3});

        System.out.println(detectCycleByTowPoint(l1));
    }
    //借助于ｈａｓｈ表来寻找第一个节点
    public static ListNode detectCycle(ListNode head){
        //边界情况处理
        if (head == null || head.next == null){
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        while (head.next !=null){
            if (nodeSet.contains(head)){
                return head;
            }else {
                nodeSet.add(head);
                head = head.next;
            }
        }
        return null;
    }
    //通过快慢指针来寻找入口节点
    public static ListNode detectCycleByTowPoint(ListNode head){
        //边界判断
        if (head == null || head.next ==null){
            return null;
        }
        //通过快慢指针来判断是否有环，在有环情况下，慢指针回到起点，两者重新开始走，再次相遇的节点便是入口节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                //相遇时slow节点重新回到起点，两者再次开始出发，再次相遇的节点即为环进入的节点
                fast = head;
                slow = slow.next;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
