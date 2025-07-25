package greedyAlgos;

import java.util.*;

public class JobSequencing {
    static class Job {
        int deadline;
        int profit;
        int id; // 0(A), 1(B), 2(C), 3(D)

        public Job(int i, int p, int d) {
            id = i;
            profit = p;
            deadline = d;
        }
    }

    public static void main(String[] args) {
        int[][] jobsInfo = {{4,20}, {2,10}, {1,40}, {1,30}}; //{deadline, profit}

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i , jobsInfo[i][1], jobsInfo[i][0]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // Descending Order of Profit

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max Jobs: " + seq.size());
        System.out.println(seq);
    }
}
