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

    record Pair(int v, int d) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.d, other.d);
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        int[] vis = new int[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (vis[curr.v()] == 0) {
                vis[curr.v()] = 1;

                for (int i = 0; i < graph[curr.v()].size(); i++) {
                    Edge e = graph[curr.v()].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt= e.weight;

                    if (dist[v] > dist[u] + wt) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(e.dest, dist[v]));
                    }
                }
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        dijkstra(graph, 0);

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
