import java.util.Arrays;

public class GraphColoring {
    private int V;
    private int[] colors;
    private int[][] graph;
    private int m;

    public GraphColoring(int V) {
        this.V = V;
        colors = new int[V];
        Arrays.fill(colors, -1);
        graph = new int[V][V];
    }

    public void graphColoring(int m) {
        if (graphColoringUtil(0, m)) {
            printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean graphColoringUtil(int v, int m) {
        if (v == V) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                colors[v] = c;

                if (graphColoringUtil(v + 1, m)) {
                    return true;
                }

                colors[v] = -1;
            }
        }
        return false;
    }

    private boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && colors[i] == c) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " is colored with color " + colors[i]);
        }
    }

    public static void main(String[] args) {
        GraphColoring coloring = new GraphColoring(4);
        coloring.m = 3; // Number of colors available
        coloring.graph = new int[][] {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };
        coloring.graphColoring(coloring.m);
    }
}
