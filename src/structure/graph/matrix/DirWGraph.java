package structure.graph.matrix;

/**
 * @author: reiserx
 * Date:2019/4/3
 * Des:图-有向带权图-邻接矩阵表示
 */
public class DirWGraph {

    //顶点个数
    private int v;
    //邻接矩阵
    private int adj[][];

    DirWGraph(int size) {
        this.v = size;
        adj = new int[size][size];
    }


    public void addEdge(int s, int t, int w) {
        adj[s][t] = w;
    }


}
