package stack;

public class LeetCode200 {
  public static void main(String[] args) {
   char [][]grid = { 
           {'1','1','1','1','0'}, 
           {'1','1','0','1','0'},
           {'1','1','0','0','0'},
           {'0','0','0','0','0'}};
   int num = new LeetCode200().numIslands(grid);
   System.out.println(num);
  }
  //解决思路还是有问题
  byte[][] visited = new byte[300][300];
  // use BFS
  public int numIslands(char[][] grid) {
    int num = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 0 && grid[i][j] == '1') {
          DFS(i, j, m, n,grid);
          num++;
        }
      }
    }
    return num;
  }

  private void DFS(int i, int j, int m, int n, char[][] grid) {
    //越界直接终止
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return;
    }
    if (grid[i][j] == '0') {
      return;
    }
    visited[i][j] =1;
    //对相邻的节点进行搜索
    if (i+1 < m && visited[i+1][j]==0){
      DFS(i+1,j,m,n, grid);
    }
    if (i-1 >=0 && visited[i-1][j] ==0){
      DFS(i-1,j,m,n, grid);
    }
    if (j+1<n&&visited[i][j+1]==0){
      DFS(i,j+1,m,n, grid);
    }
    if (j-1>=0&&visited[i][j-1]==0){
      DFS(i,j-1,m,n, grid);
    }
  }
}
