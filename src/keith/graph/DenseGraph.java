package graph;

/**
 * 稠密图 - 邻接矩阵，数据量之间的连接性更紧
 * @author MX.Y
 * @DATE 2021/9/7 6:28
 * @qq 2690399241
 */
public class DenseGraph {
    private int m;//边数
    private int n;//节点数
    private boolean directed;//是否为有向图
    private boolean[][] g;//图的具体数据

    // 构造函数，是否有向图＋节点个数
    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0; //初始时没有任何边
        this.directed = directed;
        // g初始化为n*n的布尔矩阵，每个g[i][j]都是false，表示没有任何边
        // false是boolean型变量的默认值
        g = new boolean[n][n];
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

        if(hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;
        if(!directed)
            g[w][v] = true;
        m++;
    }

    // 判断图中是否有从v到w的边
    private boolean hasEdge(int v, int w) {
        assert  v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }
}
