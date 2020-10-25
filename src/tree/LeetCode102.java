package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
  //bfs
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      List<Integer> temp = new ArrayList<>();
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
    return result;
  }
}
