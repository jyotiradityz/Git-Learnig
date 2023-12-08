import java.util.Arrays;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class BellmanFord {
    int V, E; // Number of vertices and edges in the graph
    Edge[] edges;
    int[] distance;

    public BellmanFord(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E];
        distance = new int[V];
    }

    public void bellmanFord(int source) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges |V-1| times
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].source;
                int v = edges[j].destination;
                int weight = edges[j].weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (int i = 0; i < E; i++) {
            int u = edges[i].source;
            int v = edges[i].destination;
            int weight = edges[i].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative-weight cycle.");
                return;
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 10; // Number of edges

        BellmanFord graph = new BellmanFord(V, E);

        // Add edges
        graph.edges[0] = new Edge(0, 1, 6);
        graph.edges[1] = new Edge(0, 4, 7);
        graph.edges[2] = new Edge(1, 2, 5);
        graph.edges[3] = new Edge(1, 3, -4);
        graph.edges[4] = new Edge(1, 4, 8);
        graph.edges[5] = new Edge(2,1, -2);
        graph.edges[6] = new Edge(3, 2, 7);
        graph.edges[7] = new Edge(3, 0, 2);
        graph.edges[8] = new Edge(4, 3, 9);
        graph.edges[9] = new Edge(4, 2, -3);
        

        int source = 0; // Source vertex

        graph.bellmanFord(source);
    }
}
