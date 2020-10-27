package union;


import java.util.LinkedList;
import java.util.Queue;

public class LeetCode130 {
    /**
     * 使用交并集解决棋盘替换问题
     * 基本思路如下：
     * 将所有不能替换的节点都和一个dump节点相连，然后遍历整个棋盘，将所有棋盘值为“O”的节点都和其前后左右值为“O”的节点进行合并操作
     * ，最终将所有没有和dump节点相连的节点进行替换操作
     * @param board
     */
    public void solve(char[][] board) {
        // border judge
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        //位于边界的且值为O的节点与dumpy进行联系
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
        //方向数组，在作上下左右遍历的时候经常使用
        int[][] direction = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //将所有值为O的节点进行合并
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
        //替换掉所有值为O且未和dump节点相连的元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!uf.connected(dumpy, i * n + j)) {
                    board[i][j]='X';
                }
            }
        }
    }

    /**
     * 通过bfs来解决棋盘问题
     * @param board
     */
    public void solve2(char[][] board) {
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
