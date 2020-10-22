package stack;

import java.util.*;

public class LeetCode133 {
  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    node1.neighbors.add(node2);
    node1.neighbors.add(node4);

    node2.neighbors.add(node1);
    node2.neighbors.add(node3);

    node3.neighbors.add(node2);
    node3.neighbors.add(node4);

    node4.neighbors.add(node1);
    node4.neighbors.add(node3);

    Node clone = new LeetCode133().DFS(node1);
    System.out.println(clone);
  }

  /** 通过广度优先来对图进行遍历 */
  // 有问题，复制时，总是少几个节点？？？
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    Map<Node, Node> map = new HashMap<>();
    queue.add(node);
    map.put(node, new Node(node.val));

    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        Node cur = queue.poll();
        for (Node n : cur.neighbors) {
          if (!map.containsKey(n)) {
            map.put(n, new Node(n.val));
            queue.add(n);
          }
          // 建立与邻接节点关系
          map.get(cur).neighbors.add(map.get(n));
        }
      }
    }
    return map.get(node);
  }

  Map<Node, Node> map = new HashMap<>();

  public Node DFS(Node node) {
    // 终止条件
    if (node == null) {
      return node;
    }
    //已经复制过的话，直接返回复制过的节点
    if(map.containsKey(node)) {
      return map.get(node);
    }
    // 标记访问，并创建拷贝节点
    map.put(node, new Node(node.val));
    for (Node n : node.neighbors) {
      map.get(node).neighbors.add(DFS(n));
    }
    return map.get(node);
  }
  //  //通过递归来进行克隆
  //  public Node cloneGraphByReverse(Node node) {
  //
  //  }
}

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}
