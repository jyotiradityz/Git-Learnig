// package DAAL.Assignment_6;
import java.util.*;

public class Q1 {
    public static class Job {
        String id;
        int deadline;
        int profit;

        public Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static List<String> JS(List<Job> jobs) {
        Collections.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));
        int maxDeadline = jobs.stream().mapToInt(job -> job.deadline).max().orElse(0);
        int[] timeSlots = new int[maxDeadline + 1];
        int maxProfit = 0;
        List<String> sequence = new ArrayList<>();

        for (Job job : jobs) {
            int profit = job.profit;
            int deadline = job.deadline;
            for (int i = deadline; i > 0; i--) {
                if (timeSlots[i] == 0) {
                    timeSlots[i] = 1;
                    maxProfit += profit;
                    sequence.add(job.id);
                    break;
                }
            }
        }

        List<String> result = new ArrayList<>();
        result.add("Maximum Profit: " + maxProfit);
        result.add("Job Sequence: " + sequence);
        return result;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("p1", 1, 3));
        jobs.add(new Job("p2", 3, 5));
        jobs.add(new Job("p3", 4, 20));
        jobs.add(new Job("p4", 3, 18));
        jobs.add(new Job("p5", 2, 1));
        jobs.add(new Job("p6", 1, 6));
        jobs.add(new Job("p7", 2, 30));

        List<String> result = JS(jobs);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
