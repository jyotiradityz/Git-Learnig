// package DAAL.Assignment_6;

import java.util.*;

public class Q2 {
    public static class Item {
        int weight;
        int profit;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }

    public static List<Object> knapsackFun(int[] weights, int[] profits, int capacity, String strategy) {
        int n = weights.length;
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            order.add(i);
        }

        if (strategy.equals("largest-profit")) {
            Collections.sort(order, (a, b) -> Integer.compare(profits[b], profits[a]));
        } else if (strategy.equals("smallest-weight")) {
            Collections.sort(order, (a, b) -> Integer.compare(weights[a], weights[b]));
        } else if (strategy.equals("largest-profit-weight-ratio")) {
            Collections.sort(order, (a, b) -> Double.compare((double)profits[b] / weights[b], (double)profits[a] / weights[a]));
        }

        int result = 0;
        List<Double> knapsack = new ArrayList<>();
        for (int i : order) {
            if (weights[i] <= capacity) {
                knapsack.add(1.0);
                result += profits[i];
                capacity -= weights[i];
            } else {
                knapsack.add((double)capacity / weights[i]);
                result += (int)((double)capacity * profits[i] / weights[i]);
                break;
            }
        }

        List<Object> output = new ArrayList<>();
        output.add(result);
        output.add(knapsack);
        return output;
    }

    public static void main(String[] args) {
        int[] weights = {18, 15, 10};
        int[] profits = {25, 24, 15};
        int capacity = 20;
        String[] strategies = {"largest-profit", "smallest-weight", "largest-profit-weight-ratio"};

        for (String strategy : strategies) {
            List<Object> result = knapsackFun(weights, profits, capacity, strategy);
            int maxProfit = (int)result.get(0);
            List<Double> knapsack = (List<Double>)result.get(1);

            System.out.println("Strategy: " + strategy);
            System.out.println("Maximum Profit: " + maxProfit);
            System.out.println("Fraction of items taken: " + knapsack);
            System.out.println();
        }
    }
}
