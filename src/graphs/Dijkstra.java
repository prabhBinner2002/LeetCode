package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
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

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair (int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p) {
            return this.path - p.path; // Path based sorting for my pair
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length]; // dist[i] -> src to i
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // +Infinity
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        // BFS
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if (dist[u] + wt < dist[v]) { // update the dist of v from source
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // Print all source to vertices shortest paths
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

        System.out.println();

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 0;

        dijkstra(graph, src);
    }
}
