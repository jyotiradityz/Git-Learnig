import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {
    private int V;
    private List<List<Integer>> adjList;
    private int[] disc;
    private int[] low;
    private int time;
    private boolean[] visited;
    private List<Integer> articulationPoints;

    public ArticulationPoint(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        disc = new int[V];
        low = new int[V];
        visited = new boolean[V];
        articulationPoints = new ArrayList<>();
        time = 0;
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void findArticulationPoints() {
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }

        System.out.println("Articulation Points:");
        for (int point : articulationPoints) {
            System.out.print(point + " ");
        }
        System.out.println();

        if (articulationPoints.isEmpty()) {
            System.out.println("The graph is biconnected.");
        } else {
            System.out.println("The graph is not biconnected.");
        }
    }

    private void dfs(int u, int parent) {
        int children = 0;
        disc[u] = low[u] = ++time;
        visited[u] = true;

        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                children++;
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] >= disc[u]) {
                    if (parent != -1 || children > 1) {
                        articulationPoints.add(u);
                    }
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        ArticulationPoint graph = new ArticulationPoint(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.findArticulationPoints();
    }
}
