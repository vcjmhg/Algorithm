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

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
  public static void main(String[] args) {
    Solution solution = new SurroundedRegions().new Solution();
    // [["X","X","X","X"],["X","O","O","X"],["X","O","O","X"],["X","O","X","X"]]
    char[][] board =
        new char[][] {
          {'X', 'O', 'X', 'X'},
          {'O', 'X', 'O', 'X'},
          {'X', 'O', 'X', 'O'},
          {'O', 'X', 'O', 'X'},
          {'X', 'O', 'X', 'O'},
          {'O', 'X', 'O', 'X'}
        };
    solution.solve(board);
    System.out.println(board);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // dfs
    public void solve(char[][] board) {
      // border judge
      if (board.length == 0) {
        return;
      }
      int m = board.length;
      int n = board[0].length;
      Queue<int[]> queue = new LinkedList<>();
      byte[][] visited = new byte[m][n];
      // mark the element to 'N'(not replaced) which stand at the border of the board and whose
      // value is 'O'
      for (int i = 0; i < m; i++) {
        if (board[i][0] == 'O') {
          board[i][0] = 'N';
          queue.add(new int[] {i, 0});
        }
        if (board[i][n - 1] == 'O') {
          board[i][n - 1] = 'N';
          queue.add(new int[] {i, n - 1});
        }
      }
      for (int i = 1; i < n - 1; i++) {
        if (board[0][i] == 'O') {
          board[0][i] = 'N';
          queue.add(new int[] {0, i});
        }
        if (board[m - 1][i] == 'O') {
          board[m - 1][i] = 'N';
          queue.add(new int[] {m - 1, i});
        }
      }
      int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      // begin bfs if the value is 'N'
      while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; i++) {
          int[] cur = queue.poll();
          if (board[cur[0]][cur[1]] == 'N' && visited[cur[0]][cur[1]] == 0) {
            // expand
            for (int k = 0; k < 4; k++) {
              int x = cur[0] + direction[k][0];
              int y = cur[1] + direction[k][1];
              if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                board[x][y] = 'N';
                queue.add(new int[] {x, y});
              }
            }
          }
          visited[cur[0]][cur[1]] = 1;
        }
      }
      // replace 'Z' with 'O','O' with 'Z'
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (board[i][j] == 'O') {
            board[i][j] = 'X';
          }
          if (board[i][j] == 'N') {
            board[i][j] = 'O';
          }
        }
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
