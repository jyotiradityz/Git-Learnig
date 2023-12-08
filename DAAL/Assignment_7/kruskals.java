// package DAAL.Assignment_7;

import java.util.*;

// kruskals algorithm

public class kruskals {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int v = scn.nextInt();
        int e = scn.nextInt();

        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for(int i = 0; i < v; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();

            adj.get(v1).add(new int[]{v2, wt});
            adj.get(v2).add(new int[]{v1, wt});
        }

        int src = scn.nextInt();

        scn.close();

        kruskalsAlgo(adj, src, v);
    }

    public static void kruskalsAlgo(HashMap<Integer, List<int[]>> adj, int src, int v) {
        boolean[] visited = new boolean[v];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[]{src, 0});

        while(pq.size() > 0) {
            int[] rem = pq.remove();

            if(visited[rem[0]] == true) {
                continue;
            }

            visited[rem[0]] = true;

            System.out.println(rem[0] + " -> " + rem[1]);

            for(int[] nbr : adj.get(rem[0])) {
                if(visited[nbr[0]] == false) {
                    pq.add(new int[]{nbr[0], nbr[1]});
                }
            }
        }
    }
}
