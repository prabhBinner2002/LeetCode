package graphs;

import java.awt.desktop.QuitEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahn$TopSortBFS {
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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void calIndegree(ArrayList<Edge>[] graph, int[] indeg) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        calIndegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        //BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr + " "); // Topological Sort
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) q.add(e.dest);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraphDirected(graph);

        topSort(graph);
    }
}
