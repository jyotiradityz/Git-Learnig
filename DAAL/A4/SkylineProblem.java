// package A4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> buildingPoints = new ArrayList<>();

        // Convert each building into two points: a start point (left) with a negative height
        // and an end point (right) with a positive height.
        for (int[] building : buildings) {
            buildingPoints.add(new int[]{building[0], -building[2]});
            buildingPoints.add(new int[]{building[1], building[2]});
        }

        // Sort the building points based on their x-coordinates. If x-coordinates are the same,
        // prioritize processing the start points before the end points and higher buildings before lower ones.
        buildingPoints.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // Use a max-heap to keep track of the heights of active buildings.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.offer(0); // Add a virtual height 0 to ensure the first building's height is considered.

        int prevMaxHeight = 0;

        for (int[] point : buildingPoints) {
            int x = point[0];
            int height = Math.abs(point[1]);

            if (point[1] < 0) {
                // Start point of a building, add its height to the heap.
                maxHeap.offer(height);
            } else {
                // End point of a building, remove its height from the heap.
                maxHeap.remove(height);
            }

            int currentMaxHeight = maxHeap.peek();

            if (currentMaxHeight != prevMaxHeight) {
                // If the max height in the heap changes, add this point to the result.
                result.add(new int[]{x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {
            {2, 9, 10},
            {3, 7, 15},
            {5, 12, 12},
            {15, 20, 10},
            {19, 24, 8}
        };

        List<int[]> skyline = getSkyline(buildings);
        for (int[] point : skyline) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}
