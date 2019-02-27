package structure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: reiserx
 * Date:2019/2/18
 * Des:图-有向图-用邻接表表示
 */
public class DirGraph {
    //顶点个数
    private int v;
    //邻接表
    private List<Integer>[] adj;

    public DirGraph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int s, int t) { // s 先于 t，边 s->t
        adj[s].add(t);
    }


    public List<Integer>[] getAdj() {
        return adj;
    }
}
