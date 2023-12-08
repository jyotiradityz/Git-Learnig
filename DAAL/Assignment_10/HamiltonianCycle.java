public class HamiltonianCycle {
    private int V; // Number of vertices
    private int[] path; // To store the Hamiltonian cycle
    private int[][] graph; // Adjacency matrix of the graph

    public HamiltonianCycle(int V) {
        this.V = V;
        path = new int[V];
        graph = new int[V][V];
    }

    public void findHamiltonianCycle() {
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }

        path[0] = 0; // Start from the first vertex

        if (hamiltonianCycleUtil(1)) {
            printHamiltonianCycle();
        } else {
            System.out.println("No Hamiltonian cycle exists.");
        }
    }

    private boolean isSafe(int v, int pos) {
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    private boolean hamiltonianCycleUtil(int pos) {
        if (pos == V) {
            // Check if the last vertex is connected to the first vertex
            if (graph[path[pos - 1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;
                if (hamiltonianCycleUtil(pos + 1)) {
                    return true;
                }
                path[pos] = -1;
            }
        }

        return false;
    }

    private void printHamiltonianCycle() {
        System.out.println("Hamiltonian Cycle:");
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.print(path[0]); // To complete the cycle
    }

    public static void main(String[] args) {
        HamiltonianCycle hc = new HamiltonianCycle(5);
        hc.graph = new int[][] {
            {0, 1, 1, 1, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0}
        };

        hc.findHamiltonianCycle();
    }
}
