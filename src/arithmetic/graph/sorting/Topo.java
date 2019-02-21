package arithmetic.graph.sorting;

import structure.graph.DirGraph;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: reiserx
 * Date:2019/2/21
 * Des:拓扑排序
 */
public class Topo {
    private static int v = 8;

    private static List<Integer> adj[];


    // Kahn 算法(贪心算法),可以检测图中的环
    public void topoSortByKahn() {
        int[] inDegree = new int[v]; // 统计每个顶点的入度
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print(i + "->");
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]--;
                if (inDegree[w] == 0) queue.add(w);
            }
        }


    }

    // DFS 算法（回溯算法）
    public void topoSortByDFS() {
        // 先构建逆邻接表，边 s->t 表示，s 依赖于 t，t 先于 s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // 深度优先遍历图
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w]) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
    }


    public static void main(String[] args) {
        Topo topo = new Topo();
        DirGraph graph = new DirGraph(v);
        //0依赖于1，1执行
        graph.addEdge(0, 1);
        graph.addEdge(1, 7);
        graph.addEdge(6, 4);
        graph.addEdge(7, 5);
        graph.addEdge(5, 0);
        adj = graph.getAdj();
        topo.topoSortByKahn();
        System.out.println();
        topo.topoSortByDFS();
    }

}
