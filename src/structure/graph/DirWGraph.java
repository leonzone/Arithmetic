package structure.graph;

import java.util.LinkedList;

/**
 * Author: reiserx
 * Date:2019/3/5
 * Des:有向带权邻接表
 */
public class DirWGraph { // 有向有权图的邻接表表示
    public LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数

    public DirWGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) { // 添加一条边
        this.adj[s].add(new Edge(s, t, w));
    }

    public class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }
}
