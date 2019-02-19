package arithmetic.graph;

import structure.graph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: reiserx
 * Date:2019/2/18
 * Des:广度优先搜索
 */
public class BFS {


    private static int v = 8;

    private static List<Integer> adj[];


    public void bfs(int s, int t) {
        if (s == t) return;
        //记录已经访问过的顶点
        boolean[] visited = new boolean[v];
        visited[s] = true;

        //记录即将访问的顶点
        Queue<Integer> queue = new LinkedList();
        queue.add(s);

        //记录访问路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + "->");
    }


    public static void main(String[] args) {
        BFS bfs = new BFS();
        Graph graph = new Graph(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        adj = graph.getAdj();
        bfs.bfs(0, 7);
    }

}
