package graphs;

import java.util.ArrayList;

public class HasCycleDisjointSet {
    static int[] par;
    static int[] rank;

    public static void init(int n) {
        par = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (par[x] != x)
            par[x] = find(par[x]);
        return par[x];
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return;

        if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parB] = parA;
            rank[parA]++;
        }
    }

    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        init(V);

        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                if (i < j) {
                    if (find(i) == find(j))
                        return true;
                    union(i, j);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int V = 3;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(0);
        adj.get(0).add(2);

        System.out.println(hasCycle(adj, V));

    }
}
