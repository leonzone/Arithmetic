package arithmetic.graph.dijkstra;


import structure.graph.DirWGraph;
import structure.graph.DirWGraph.Edge;

import java.util.LinkedList;

/**
 * Author: reiserx
 * Date:2019/3/5
 * Des:最短路径算法
 */
public class Dijkstra {
    // 邻接表
    private LinkedList<Edge> adj[];
    // 顶点个数
    private int v;

    // 下面这个类是为了 dijkstra 实现用的
    public class Vertex {
        public int id; // 顶点编号 ID
        public int dist; // 从起始顶点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    // 因为 Java 提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
    private class PriorityQueue { // 根据 vertex.dist 构建小顶堆
        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll() {
            int v = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < count; i++) {
                if (nodes[i] != null && nodes[i].dist < v) {
                    index = i;
                    v = nodes[i].dist;
                }

            }
            Vertex vertex = nodes[index];
            nodes[index] = null;
            return vertex;
        }

        public void add(Vertex vertex) {
            nodes[vertex.id] = vertex;
        }

        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度 O(logn)。
        public void update(Vertex vertex) {
            nodes[vertex.id].dist = vertex.dist;
        }

        public boolean isEmpty() {
            for (Vertex v : nodes) {
                if (v != null) {
                    return false;
                }
            }
            return true;
        }


    }


    /**
     * 从顶点 s 到顶点 t 的最短路径
     *
     * @param s
     * @param t
     */
    public void dijkstra(int s, int t) {
        // 用来还原最短路径
        int[] predecessor = new int[this.v];
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; ++i) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // 小顶堆
        PriorityQueue queue = new PriorityQueue(this.v);
        // 标记是否进入过队列
        boolean[] inqueue = new boolean[this.v];
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            // 取堆顶元素并删除
            Vertex minVertex = queue.poll();
            // 最短路径产生了
            if (minVertex.id == t) {
                break;
            }
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                // 取出一条 minVetex 相连的边
                Edge e = adj[minVertex.id].get(i);
                // minVertex-->nextVertex
                Vertex nextVertex = vertexes[e.tid];
                // 更新 next 的 dist
                if (minVertex.dist + e.w < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    System.out.println("predecessor["+nextVertex.id+"]="+minVertex.id);
                    if (inqueue[nextVertex.id]) {
                        // 更新队列中的 dist 值
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }

        System.out.println("--------------");
        for (int i = 0; i < predecessor.length; i++) {
            System.out.println(i+"<-----"+predecessor[i]);
        }
        System.out.println();
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) {
            return;
        }
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }


    public static void main(String[] args) {
        DirWGraph graph = new DirWGraph(6);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        graph.addEdge(4, 5, 10);

        Dijkstra dijkstra = new Dijkstra();

        dijkstra.adj = graph.adj;
        dijkstra.v = 6;
        dijkstra.dijkstra(0, 5);

    }


}
