package graphs;
import java.util.*;

public class practice {
    static class Edge {
        int src, dest, weight;

        public Edge (int src, int dest, int weight) {
            this.dest = dest;
            this.src = src;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1 - vertex
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        //2 - vertex
        graph[2].add(new Edge(2,4,3));

        //3 - vertex
        graph[3].add(new Edge(3,5,1));

        //4 - vertex
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    record P(int curr, int cost) implements Comparable<P> {
        @Override
        public int compareTo(P p) {
            return this.cost - p.cost;
        }
    }

    public static int dijkstra(List<List<Integer[]>> graph, int src, int dest) {
        int[] dis = new int[graph.size()];
        int[] par = new int[graph.size()];
        PriorityQueue<P> q = new PriorityQueue<>();

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        par[src] = -1;

        q.offer(new P(src, 0));

        while (!q.isEmpty()) {
            P curr = q.poll();

            if (curr.cost != dis[curr.curr]) continue;

            if (curr.curr == dest) break;

            for (Integer[] list : graph.get(curr.curr)) {
                    if (dis[list[0]] > dis[curr.curr] + list[1]) {
                        dis[list[0]] = dis[curr.curr] + list[1];
                        q.offer(new P(list[0], dis[list[0]]));
                        par[list[0]] = curr.curr;
                    }
            }
        }

        if (dis[dest] == Integer.MAX_VALUE) {
            System.out.println("No path");
            return Integer.MAX_VALUE; // or return -1;
        }

        ArrayList<Integer> path = new ArrayList<>();

        for (int i = dest; i != -1; i = par[i]) {
            path.add(i);
        }

        Collections.reverse(path);
        System.out.println(path);

        return dis[dest];
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (util(graph, vis, i, -1)) return true;
            }
        }

        return false;
    }

    public static boolean util(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;

        for (Edge e: graph[curr]) {
            int src = e.src;
            int dest = e.dest;
            if (!vis[dest]) {
                if (util(graph, vis, dest, src)) return true;
            } else if (e.dest != par) {
                return true;
            }
        }

        return false;
    }

    public static void topSort(List<List<Integer>> g) {
        int[] indegree = new int[g.size()];

        for (int i = 0; i < g.size(); i++) {
            for (int neigh : g.get(i)) {
                indegree[neigh]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.println(curr);

            for (int neigh : g.get(curr)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) q.offer(neigh);
            }
        }
    }

    record Pair(int v, int cost) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    class Solution {
        static class Pair {
            int r, c, t;
            Pair(int r, int c, int t) {
                this.r = r;
                this.c = c;
                this.t = t;
            }
        }

        public int orangesRotting(int[][] grid) {
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            int fresh = 0;
            int timer = 0;

            Queue<Pair> q = new LinkedList<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == 2) q.add(new Pair(i, j, 0));
                    else if (grid[i][j] == 1) fresh++;
                }
            }

            while (!q.isEmpty()) {
                Pair p = q.remove();
                timer = p.t;

                for (int i = 0 ; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    if (nr >= 0 && nc >= 0 &&
                            nr < grid.length && nc < grid[0].length &&
                            grid[nr][nc] == 1) {
                        fresh--; // to check corner case
                        grid[nr][nc] = 2; // visited
                        q.add(new Pair(nr, nc, timer + 1));
                    }
                }
            }

            return fresh >= 1 ? -1 : timer;
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);



//        int v = 6;
//        List<List<Integer>> adj = new ArrayList<>();
//
//        adj.add(Arrays.asList(1, 2));       // 0
//        adj.add(Arrays.asList(0, 3, 4));    // 1
//        adj.add(Arrays.asList(0, 4));       // 2
//        adj.add(Arrays.asList(1, 5));       // 3
//        adj.add(Arrays.asList(1, 2));       // 4
//        adj.add(Arrays.asList(3));          // 5

        List<List<Integer>> undirected = new ArrayList<>();

        undirected.add(Arrays.asList(1, 2));  // 0
        undirected.add(Arrays.asList(0, 2));  // 1
        undirected.add(Arrays.asList(0, 1));  // 2

        List<List<Integer>> directed = new ArrayList<>();

        directed.add(Arrays.asList(1));  // 0 → 1
        directed.add(Arrays.asList(2));  // 1 → 2
        directed.add(Arrays.asList(0));  // 2 → 0 (cycle back to 0)

        List<List<Integer>> bipartite = new ArrayList<>();

        bipartite.add(Arrays.asList(2, 3));  // 0
        bipartite.add(Arrays.asList(2, 3));  // 1
        bipartite.add(Arrays.asList(0, 1));  // 2
        bipartite.add(Arrays.asList(0, 1));  // 3

        List<List<Integer>> dag = new ArrayList<>();

        dag.add(Arrays.asList(1, 2));  // 0
        dag.add(Arrays.asList(3, 4));  // 1
        dag.add(Arrays.asList(4));     // 2
        dag.add(Arrays.asList(5));      // 3
        dag.add(Arrays.asList(5));      // 4
        dag.add(Arrays.asList());      // 5

    }
}
