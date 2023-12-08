// package DAAL.Assignment_8;
import java.util.*;

// along with shortest distance also provide the path

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for(int i = 0;i < n;i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            int w = scn.nextInt();

            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(new int[]{u, w});
        }

        int src = scn.nextInt(), dest = scn.nextInt();
        scn.close();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        boolean[] vis = new boolean[n];

        while(pq.size() > 0){
            int[] rem = pq.remove();

            if(vis[rem[0]]) continue;

            vis[rem[0]] = true;

            if(rem[0] == dest){
                System.out.println(rem[1]);
                break;
            }

            for(int[] e: adj.get(rem[0])){
                if(!vis[e[0]]){
                    pq.add(new int[]{e[0], rem[1] + e[1]});
                }
            }
        }

        System.out.println("Path: ");
        printPath(adj, src, dest, vis, "");
    }

    public static void printPath(HashMap<Integer, List<int[]>> adj, int src, int dest, boolean[] vis, String psf){
        if(src == dest){
            System.out.println(psf + dest);
            return;
        }

        for(int[] e: adj.get(src)){
            if(!vis[e[0]]){
                printPath(adj, e[0], dest, vis, psf + src);
            }
        }
    }
}
//  0 1 1
//  0 2 2
//  1 4 2
//  1 3 3
//  1 2 1
//  2 4 2
//  2 3 1
//  3 4 4
//  3 5 3
//  4 5 3