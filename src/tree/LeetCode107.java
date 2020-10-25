package tree;

import java.util.*;

public class LeetCode107 {
  //use bfs ,just like LeetCode102
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      List<Integer> temp = new LinkedList<>();
      for (int i = 0; i < sz; i++) {
        TreeNode cur = queue.poll();
        temp.add(cur.val);
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
      result.add(temp);
    }
    Collections.reverse(result);
    return result;
  }
}
