package arithmetic.graph;

import structure.graph.Graph;

import java.util.List;

/**
 * Author: reiserx
 * Date:2019/2/18
 * Des:深度优先搜索
 */
public class DFS {
    boolean found = false;

    private static int v = 8;

    private static List<Integer> adj[];

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    //使用回溯思想
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {

        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); i++) {

            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
            if (found) {
                break;
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
        DFS dfs = new DFS();
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
        dfs.dfs(0, 7);
    }
}
