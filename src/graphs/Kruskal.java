package graphs;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    static record Edge(int src, int dest, int wt) implements Comparable<Edge>{
        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4; // Vertices
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) return x;
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        Collections.sort(edges); // O(E log E)
        int mstCost = 0;
        int count = 0;
        for (int i = 0; count < V-1; i++) { // O(V)
            Edge e = edges.get(i);
            int src = e.src;
            int dest = e.dest;
            int wt = e.wt;

            int parA = find(src);
            int parB = find(dest);
            if (parA != parB) {
                union(src, dest);
                mstCost += wt;
                count++;
            }
        }

        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        init();
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        kruskalsMST(graph, V);
    }
}
