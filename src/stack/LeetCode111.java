package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class LeetCode111 {
  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;
    int length = new LeetCode111().minDepth(node1);
    System.out.println(length);
  }
  // 使用BFS来获取其最短长度
  public int minDepth(TreeNode root) {
    if (root.left == null && root.right == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    int step = 1;

    // 起始节点入队列
    queue.add(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i=0;i<sz;i++){
        TreeNode cur = queue.poll();
        // 目标节点判断
        if (cur.left == null && cur.right == null) {
          return step;
        }
        // 遍历节点并入队
        TreeNode left = cur.left;
        if (left != null) {
          queue.add(left);
        }
        TreeNode right = cur.right;
        if (right != null) {
          queue.add(right);
        }
      }
      step++;
    }
    return step;
  }
}
