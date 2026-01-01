package graphs;

public class DisjointSetUnion {
    static int n = 7;

    static int par[] = new int[7];
    static int rank[] = new int[7];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
           par[i] = i;
        }
    }

    // Path compression: Optimized
    public static int find(int x) {
        if (x == par[x]) return x;
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        // Both same, so parent of b is parent of a
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        union(2,4);
        union(3,4);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
        System.out.println(find(5));
    }
}
