package graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public static void bellmanFordSimple(ArrayList<Edge> graph, int src, int V) {
        int[] dist = new int[V];

        for (int i = 0; i < dist.length; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        //TC : O(VE)
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < graph.size(); j++) {
                    Edge e = graph.get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                        dist[v] = dist[u] + wt;
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
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
