package linkedlist;


import java.util.HashMap;
import java.util.Map;

/** 复制带有随即指针的链表 */
public class LeetCode138 {
  public static void main(String[] args) {
    Node l = new Node(0);
    Node l1 = new Node(1);
    Node l2 = new Node(2);
    Node l3 = new Node(3);
    Node l4 = new Node(4);
    Node l5 = new Node(5);
    l.next = l1;
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    
    l.random = l5;
    l1.random = l3;
    l2.random = l4;
    l3.random = l;
    Node copyNode = copyRandomListByStorage(l);
    System.out.println(copyNode.val);
  }
  // 此处使用的思路很奇特，直接复制一个多余的节点放置到原来节点后边
  public static Node copyRandomList(Node head) {
    //边界判断
    if(head == null){
      return null;
    }
   //复制节点
    Node copy = null,current = head;
    while (current != null){
      copy = new Node(current.val);
      copy.next = current.next;
      current.next = copy;
      current = current.next.next;
    }
    //解决随机指针复制的问题
    current = head;
    while (current != null ){
      if (current.random !=null){
        current.next.random = current.random.next;
      }
      current = current.next.next;
    }
    //将原来连边和新链表进行分离
    Node copyHead = head.next,copyCurrent = copyHead;
    current = head;
    while (current !=null && current.next.next !=null){
      current.next = current.next.next;
      copyCurrent.next =copyCurrent.next.next;
      current = current.next;
      copyCurrent = copyCurrent.next;
    }
    current.next = null;
    copyCurrent.next = null;
    return copyHead;
  }
  //最容易想到的办法是借助于存储的思想，通过HashMap来辅助实现
  public static Node copyRandomListByStorage(Node head){
    //边界判断
    if(head == null) {
      return  null;
    }
    //第一遍复制的时候，以原来的节点作为key，以复制的节点作为value来填充一个HashMap
    Map<Node,Node> nodeMap = new HashMap<Node,Node>();
    Node current = head,copy;
    while (current != null){
      copy = new Node(current.val);
      nodeMap.put(current,copy);
      current = current.next;
    }
    //第二遍遍历时，建立起仿照原来的链表，建立起next与random指针的关系
    current = head;
    copy = nodeMap.get(head);
    Node copyCurrent = copy;
    while (current !=null){
      if (current.next != null){
        copyCurrent.next = nodeMap.get(current.next);
      }
      if (current.random != null){
        copyCurrent.random = nodeMap.get(current.random);
      }
      current = current.next;
      copyCurrent =copyCurrent.next;
    }
    return copy;
  } 
}
