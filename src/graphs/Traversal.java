package graphs;

import java.util.*;

public class Traversal {
    static class Edge {
        int src, dest, weight;

        public Edge (int src, int dest, int weight) {
            this.dest = dest;
            this.src = src;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 3));
        graph[1].add(new Edge(1, 3, 1));

        //2 - vertex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        //3 - vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        //4 - vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        //5 - vertex
        graph[4].add(new Edge(5,3,1));
        graph[4].add(new Edge(5,4,1));
        graph[4].add(new Edge(5,6,1));

        //6 - vertex
        graph[4].add(new Edge(6,5,1));
    }

    public static void bfs(ArrayList<Edge>[] graph) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(0); // source -> 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) { // visit curr
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static ArrayList<Integer> BFS( ArrayList<ArrayList<Integer>>adj)
    {
        int n = adj.size();
        int vis[]= new int[n];
        ArrayList<Integer>ans= new ArrayList<>();
        Queue<Integer>q= new LinkedList<>();
        q.add(0);
        vis[0]=1;
        while(!q.isEmpty())
        {
             int curr= q.remove();
             ans.add( curr);

             for( int conn: adj.get(curr) )
             {
                 if( vis[conn]==0)
                 {
                     q.add(conn);
                     vis[conn]=1;
                 }
             }
        }
        return  ans;
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        // Visit curr :
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    static void dfs( int curr, ArrayList<ArrayList<Integer>>adj, int vis[], ArrayList<Integer> ans)
    {
        ans.add( curr );
        vis[curr]=1;

        for( int conn : adj.get(curr) )
        {
            if (vis[conn] == 0)
            {
                dfs(conn, adj, vis, ans);
            }
        }
    }

    static ArrayList<Integer> DFS( ArrayList<ArrayList<Integer>>adj)
    {
        int n = adj.size();
        int vis[]= new int[n];

        ArrayList<Integer>ans= new ArrayList<>();

        dfs( 0, adj, vis, ans);

        return ans;
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) return true;
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i); // e.dest -> neighbour
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V]; // null -> empty arrayList
        createGraph(graph);

        bfs(graph);
        System.out.println();
        dfs(graph, 0, new boolean[V]);
        System.out.println(hasPath(graph, 3, 6, new boolean[V]));
    }
}

