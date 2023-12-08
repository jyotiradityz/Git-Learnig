// package Assignment_8;??

import java.util.*;

class Node implements Comparable<Node> {
    int vertex;
    int minDistance;

    Node(int vertex, int minDistance) {
        this.vertex = vertex;
        this.minDistance = minDistance;
    }

    public int compareTo(Node otherNode) {
        return this.minDistance - otherNode.minDistance;
    }
}

public class Dij {
    private int[][] graph;
    private int numberOfVertices;

    public Dij(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        graph = new int[numberOfVertices][numberOfVertices];
    }

    public void addEdge(int sourceVertex, int destinationVertex, int weight) {
        graph[sourceVertex][destinationVertex] = weight;
    }

    public void dijkstraAlgo(int sourceVertex) {
        boolean[] isMinimumDistanceCalculated = new boolean[numberOfVertices];
        int[] minimumDistance = new int[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            minimumDistance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        minimumDistance[sourceVertex] = 0;
        priorityQueue.add(new Node(sourceVertex, minimumDistance[sourceVertex]));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int vertex = node.vertex;
            if (!isMinimumDistanceCalculated[vertex]) {
                isMinimumDistanceCalculated[vertex] = true;
                for (int neighbor = 0; neighbor < numberOfVertices; neighbor++) {
                    if (graph[vertex][neighbor] != 0 && !isMinimumDistanceCalculated[neighbor]) {
                        if (minimumDistance[vertex] + graph[vertex][neighbor] < minimumDistance[neighbor]) {
                            minimumDistance[neighbor] = minimumDistance[vertex] + graph[vertex][neighbor];
                            priorityQueue.add(new Node(neighbor, minimumDistance[neighbor]));
                        }
                    }
                }
            }
        }

        printSolution(minimumDistance);
    }

    public void printSolution(int[] minimumDistance) {
        System.out.println("Vertex   Distance from Source Vertex");
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.println(i + " \t\t " + minimumDistance[i]);
        }
    }

    public static void main(String[] args) {
        Dij dijkstra = new Dij(9);

        dijkstra.addEdge(0, 1, 4);
        dijkstra.addEdge(0, 7, 8);
        dijkstra.addEdge(1, 2, 8);
        dijkstra.addEdge(1, 7, 11);
        dijkstra.addEdge(2, 3, 7);
        dijkstra.addEdge(2, 8, 2);
        dijkstra.addEdge(2, 5, 4);
        dijkstra.addEdge(3, 4, 9);
        dijkstra.addEdge(3, 5, 14);
        dijkstra.addEdge(4, 5, 10);
        dijkstra.addEdge(5, 6, 2);
        dijkstra.addEdge(6, 7, 1);
        dijkstra.addEdge(6, 8, 6);
        dijkstra.addEdge(7, 8, 7);

        dijkstra.dijkstraAlgo(0);
    }
}