package graphs;

import java.util.*;

public class CourseSchedule {
    public static void getIndegree(List<List<Integer>> adj, int[] indegree) {
        for (List<Integer> ver : adj) {
            for (int i : ver) {
                indegree[i]++;
            }
        }
    }

    public static boolean isPossible(int n, int[][] pre) {
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] ver : pre) {
            int a = ver[1];
            int b = ver[0];
            adj.get(a).add(b);
        }

        getIndegree(adj, indegree);

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0) q.offer(i);

        int count = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neigh : adj.get(curr)) {
                if (!vis[neigh]) {
                    indegree[neigh]--;
                    if (indegree[neigh] == 0) {
                        q.offer(neigh);
                    }
                }
            }
        }

        return count == n;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0}, {3,1}, {3,2}};
        System.out.println(isPossible(numCourses, prerequisites));
    }
}
