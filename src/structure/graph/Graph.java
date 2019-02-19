package structure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: reiserx
 * Date:2019/2/18
 * Des:图-无向图-用邻接表表示
 */
public class Graph {
    //顶点个数
    private int v;
    //邻接表
    private List<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }


    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }


    public List<Integer>[] getAdj() {
        return adj;
    }
}
