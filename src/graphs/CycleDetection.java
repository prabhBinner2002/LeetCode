package graphs;

import java.util.*;

public class CycleDetection {
    static class Edge {
        int src, dest;

        public Edge (int src, int dest) {
            this.dest = dest;
            this.src = src;
        }
    }

    static void createGraphUndirected(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1 - vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        //2 - vertex
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        //3 - vertex
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        //4 - vertex
        graph[4].add(new Edge(4,3));
    }

    static void createGraphDirected(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1 - vertex
        graph[1].add(new Edge(1, 3));

        //2 - vertex
        graph[2].add(new Edge(2,3));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if (util(graph, vis, i, -1)) {
                    return true; // cycle exists in one of the component
                }
            }
        }
        return false;
    }

    public static boolean util(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) { // Case : 3
                if (util(graph, vis, e.dest, curr))
                    return true;
            }
            else if (vis[e.dest] && e.dest != par) {// Case : 1
                return true;
            }
            // Case : 2 Do nothing, continue;
        }

        return false;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stk = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i])
                if (isCyclicUtil(graph, i, vis, stk))
                    return true;
        }

        return false;
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stk) {
        vis[curr] = true;
        stk[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stk[e.dest]) return true;
            if (!vis[e.dest] && isCyclicUtil(graph, e.dest, vis, stk)) return true;
        }

        stk[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraphUndirected(graph);

        System.out.println(isCycle(graph));
    }
}
