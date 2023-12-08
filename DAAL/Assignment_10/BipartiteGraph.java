import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    private int V;
    private int[][] graph;

    public BipartiteGraph(int V) {
        this.V = V;
        graph = new int[V][V];
    }

    public boolean isBipartite() {
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isBipartiteUtil(i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteUtil(int src, int[] color) {
        color[src] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (graph[u][u] == 1) {
                return false;
            }

            for (int v = 0; v < V; v++) {
                if (graph[u][v] == 1 && color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if (graph[u][v] == 1 && color[u] == color[v]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph graph = new BipartiteGraph(4);
        graph.graph = new int[][] {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };

        if (graph.isBipartite()) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is not Bipartite");
        }
    }
}
