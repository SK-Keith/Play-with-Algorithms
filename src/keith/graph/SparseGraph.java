package graph;

import java.util.Vector;

/**
 * 稀疏图 - 邻接表
 * @author MX.Y
 * @DATE 2021/9/7 6:28
 * @qq 2690399241
 */
public class SparseGraph {

    private int m;//边的个数
    private int n;//节点个数
    private boolean directed;//是否为有向图
    private Vector<Integer>[] g;    //图的具体数据

    // 构造函数，节点的个数进行初始化
    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.directed = directed;
        this.m = 0;//初始时没有边
        // g初始化为n个空的vector,表示每一个g[i]都是空，即没有任何边
        g = new Vector[n];
        for (int i = 0;i<n;i++) {
            g[i] = new Vector<Integer>();
        }
    }

    // 返回节点个数
    public int V() {
        return n;
    }

    // 返回边的个数
    public int E() {
        return m;
    }

    // 向图中添加一个边
    public void addEdge(int v, int w) {
        assert  v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v!=w && !directed) {
            g[w].add(v);
        }
        m++;
    }

    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {
        assert  v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0;i<g[v].size();i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SparseGraph graph = new SparseGraph(7, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
    }
}
