package graphs;

import java.util.*;

public class BipartiteGraph {
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
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        //2 - vertex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        //3 - vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));

        //4 - vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // BFS
                q.add(i);
                color[i] = 0; // Yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // e.dest
                        if (color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false; // Not Bipartite
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
