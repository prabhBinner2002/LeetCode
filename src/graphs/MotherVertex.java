package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MotherVertex {
    static record Edge(int src, int dest) {}

    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < V; i++) {
            boolean[] vis = new boolean[V];
            if (!vis[i]) {
                int visElements = dfs(adj, i, vis);
                if (visElements == V) return i;
            }
        }

        return -1;
    }

    public static int dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis) {
        vis[src] = true;

        int verticesVisited = 1;

        for (int v : adj.get(src)) {
            if (!vis[v]) {
                verticesVisited += dfs(adj, v, vis);
            }
        }

        return verticesVisited;
    }

    public static int motherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < V; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[V];

            vis[i] = true;
            q.offer(i);
            int count = 1;

            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int neigh : adj.get(curr)) {
                    if (!vis[neigh]) {
                        q.offer(neigh);
                        vis[neigh] = true;
                        count++;
                    }
                }
            }

            if (count == V) return i;
        }

        return -1;
    }

    public static int mVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        if (V == 0) return -1;

        boolean[] vis = new boolean[V];
        int v = -1;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                DFS(adj, i, vis);
                v = i;
            }
        }

        vis = new boolean[V];
        DFS(adj, v, vis);

        for (boolean e : vis)
            if (!e) return -1;

        return v;
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis) {
        vis[curr] = true;

        for (int neigh : adj.get(curr)) {
            if (!vis[neigh]) {
                DFS(adj, neigh, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();

    }
}
