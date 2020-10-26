package union;


public class UF {
//  记录联通分量的个数
  private int count;
//  记录节点的父节点，例如x的父节点为parent[x]
  private int[] parent;

  private int size[];
  public UF(int count) {
    this.count = count;
    // when init UF, the node point themself.
    //初始化时，节点指向其本身
    parent = new int[count];
    size = new int[count];
    for (int i = 0; i < count; i++) {
      parent[i] = i;
      size[i] =1;
    }
  }

  /**
   * 返回一个节点的根节点
   * @param x 目标节点
   * @return 目标节点根节点
   */
  public int find(int x) {
    while (x != parent[x]) {
      x = parent[x];
    }
    return x;
  }

  /**
   * 
   * @param p
   * @param q
   */
  public void union(int p, int q) {
    if (connected(p,q)) {
      return;
    }
    int parentP = find(p);
    int parentQ = find(q);
    parent[parentP] = parentQ;
    count--;
  }

  /**
   * 判断两个并查集是否联通
    * @param p
   * @param q
   * @return
   */ 
  public boolean connected(int p, int q){
    int parentP = find(p);
    int parentQ =find(q);
    return parentP == parentQ;
  }
}
