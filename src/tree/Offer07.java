package tree;

import java.util.HashSet;
import java.util.Set;

public class Offer07 {
  public static void main(String[] args) {
    Offer07 solution = new Offer07();
    int[] preorder = {4, 3, 1, 2};
    int[] inorder = {1, 2, 3, 4};
    TreeNode root = solution.buildTree(preorder, inorder);
    System.out.println(root.val);
  }

  Set<Integer> visited = new HashSet<>();
  int[] preorder, inorder;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // border case
    if (preorder.length == 0) {
      return null;
    }
    this.preorder = preorder;
    this.inorder = inorder;
    TreeNode root = getRoot(0, inorder.length - 1);
    return root;
  }
  // 获取left到right的根节点
  private TreeNode getRoot(int left, int right) {
    if (left < 0 || right < 0 || right >= preorder.length || left > right) {
      return null;
    }
    if (left == right) {
      visited.add(inorder[left]);
      return new TreeNode(inorder[left]);
    }
    int index = -1;
    for (int i = left; i <= right; i++) {
      if (!visited.contains(preorder[i])) {
        index = i;
        visited.add(preorder[index]);
        break;
      }
    }
    if (index == -1) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[index]);
    index = find(inorder, preorder[index]);
    TreeNode leftNode = getRoot(left, index - 1);
    TreeNode rightNode = getRoot(index + 1, right);
    root.left = leftNode;
    root.right = rightNode;
    return root;
  }
  // 查找查找data在inorder数组中的位置
  private int find(int[] inorder, int data) {
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == data) {
        return i;
      }
    }
    return -1;
  }
}
