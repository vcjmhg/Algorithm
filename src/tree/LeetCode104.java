package tree;

import java.util.LinkedList;
import java.util.Queue;

/** max deepth of bi tree */
public class LeetCode104 {
  //use dfs to get the depth of tree
  public int maxDepth(TreeNode root) {
    // border
    if (root == null) {
      return 0;
    }
    int step = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
      step++;
    }
    return step;
  }
}
