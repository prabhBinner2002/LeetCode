package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Allpaths {
    static class Edge {
        int src, dest;

        public Edge (int src, int dest) {
            this.dest = dest;
            this.src = src;
        }
    }

    static void createGraphDirected(ArrayList<Edge>[] graph) { // O(V + E)
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void getAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
        ArrayList<String> ans = new ArrayList<>();
        util(graph, src, dest, path, ans);

        for (String s : ans) {
            System.out.println(s);
        }
    }

    public static void util(ArrayList<Edge>[] graph, int src, int dest, String path, ArrayList<String> ans) {
        if (src == dest) {
            ans.add(path + dest);
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            util(graph, e.dest, dest, path + src, ans);
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraphDirected(graph);

        int src = 5;
        int dest = 1;
        getAllPaths(graph, src, dest, "");
    }
}
