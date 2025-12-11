package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FlightswithKStops {
    record Edge(int src, int dest, int wt) {}

    public static void createGraph(ArrayList<Edge>[] graph, int[][] flights) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    record Info(int vertex, int cost, int stops) {}

    public static int cheapestFlight(int n, int[][] flights, int src, int dest, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, flights);

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) break;

            for (Edge e: graph[curr.vertex]) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[v] > curr.cost + wt && curr.stops <= k) {
                    dist[v] = dist[u] + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0, dest = 3, k = 1;

        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
}
