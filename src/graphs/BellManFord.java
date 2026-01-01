package graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellManFord {
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
        graph[1].add(new Edge(1, 2, -4));

        //2 - vertex
        graph[2].add(new Edge(2,3,2));

        //3 - vertex
        graph[3].add(new Edge(3,4,4));

        //4 - vertex
        graph[4].add(new Edge(4,1,-1));
    }

    public static void createGraph2(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2,3,2));
        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        int V = graph.length;
        //TC : O(VE)
        //algo -- O(V)
        for (int i = 0; i < V - 1; i++) {
            //Edges
            for (int j = 0; j < graph.length; j++) { // O(E)
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                        dist[v] = dist[u] + wt;
                }
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    static int[] bellmanFord(int V, int[][] edges, int src) {

        // Initially distance from source to all other vertices
        // is not known(Infinite).
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        // Relaxation of all the edges V times, not (V - 1) as we
        // need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {

                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V - 1)
                        return new int[]{-1};

                    // Update shortest distance to node v
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }

    public static void bellmanFordSimple(ArrayList<Edge> graph, int src, int V) {
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;

        // Relax edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge e : graph) {
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;

                if (dist[u] != Long.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Negative cycle check
        for (Edge e : graph) {
            int u = e.src;
            int v = e.dest;
            int wt = e.weight;

            if (dist[u] != Long.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("Negative cycle detected");
                return;
            }
        }

        // Print distances
        for (int i = 0; i < V; i++) {
            if (dist[i] == Long.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
//        ArrayList<Edge>[] graph = new ArrayList[V];
//        createGraph(graph);
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph2(graph);

        int src = 0;

        bellmanFordSimple(graph, src, V);
    }
}
