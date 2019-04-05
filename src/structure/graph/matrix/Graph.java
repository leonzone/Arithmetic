package structure.graph.matrix;

/**
 * @author: reiserx
 * Date:2019/4/3
 * Des:图-无向图-邻接矩阵表示
 */
public class Graph {

    //顶点个数
    private int v;
    //邻接矩阵
    private int adj[][];

    Graph(int size) {
        this.v = size;
        adj = new int[size][size];
    }


    public void addEdge(int s, int t) {
        adj[s][t] = 1;
        adj[t][s] = 1;
    }


}
