package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode103 {
  //与leetcode相比就是在增加元素的时候进行一次判断，看是直接插入到List后边还是放到它的前边
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    // border judge
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<List<Integer>> result = new LinkedList<>();
    boolean isReverse = true;
    while (!queue.isEmpty()) {
      int sz = queue.size();
      isReverse = !isReverse;
      LinkedList<Integer> temp = new LinkedList<>();
      for (int i = 0; i < sz; i++) {
        TreeNode cur = queue.poll();
        //judge the method of add
        if (!isReverse) {
          temp.add(cur.val);
        } else {
          temp.addFirst(cur.val);
        }
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
