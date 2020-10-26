// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
// rrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
// .
//
// Example:
//
//
// X X X X
// X O O X
// X X O X
// X O X X
//
//
// After running your function, the board should be:
//
//
// X X X X
// X X X X
// X X X X
// X O X X
//
//
// Explanation:
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
// e border of the board are not flipped to 'X'. Any 'O' that is not on the border
// and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
// s are connected if they are adjacent cells connected horizontally or vertically.
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 407 👎 0

package com.shuzijun.leetcode.editor.cn;

import union.UF;

public class SurroundedRegions {
  public static void main(String[] args) {
    Solution solution = new SurroundedRegions().new Solution();
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void solve(char[][] board) {
      // border judge
      if (board.length == 0) {
        return;
      }
      int m = board.length;
      int n = board[0].length;
      UF uf = new UF(m * n + 1);
      int dumpy = m * n;

      for (int i = 0; i < m; i++) {
        if (board[i][0] == 'O') {
          uf.union(dumpy, n * i);
        }
        if (board[i][n - 1  ] == 'O') {
          uf.union(dumpy, n * i + n - 1);
        }
      }
      for (int i = 0; i < n; i++) {
        if (board[0][i] == 'O') {
          uf.union(dumpy, i);
        }
        if (board[m - 1][i] == 'O') {
          uf.union(dumpy, (m - 1) * n + i);
        }
      }

      int[][] direction = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      for (int i = 1; i < m - 1; i++) {
        for (int j = 1; j < n - 1; j++) {
          if (board[i][j] == 'O') {
            for (int k = 0; k < 4; k++) {
              int x = i + direction[k][0];
              int y = j + direction[k][1];
              if (board[x][y] == 'O') {
                uf.union(i * n + j, x * n + y);
              }
            }
          }
        }
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (!uf.connected(dumpy, i * n + j)) {
            board[i][j]='X';
          }
        }
      }
    }
  }

  class UF {
    //  记录联通分量的个数
    private int count;
    //  记录节点的父节点，例如x的父节点为parent[x]
    private int[] parent;

    private int size[];

    public UF(int count) {
      this.count = count;
      // when init UF, the node point themself.
      // 初始化时，节点指向其本身
      parent = new int[count];
      size = new int[count];
      for (int i = 0; i < count; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    /**
     * 返回一个节点的根节点
     *
     * @param x 目标节点
     * @return 目标节点根节点
     */
    public int find(int x) {
      while (x != parent[x]) {
        parent[x] = parent[parent[x]];
        x = parent[x];
      }
      return x;
    }

    /**
     * @param p
     * @param q
     */
    public void union(int p, int q) {
      if (connected(p, q)) {
        return;
      }
      int rootP = find(p);
      int rootQ = find(q);
      if (size[rootP] > size[rootQ]) {
        parent[rootQ] = rootP;
        size[rootP] += size[rootQ];
      } else {
        parent[rootP] = rootQ;
        size[rootQ] += size[rootP];
      }
      count--;
    }

    /**
     * 判断两个并查集是否联通
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
      int parentP = find(p);
      int parentQ = find(q);
      return parentP == parentQ;
    }
    public int count(){
      return this.count;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}

