// Design and implement Bellman ford algorithm to find the shortest path from a given source
// to all other nodes using dynamic programming.

public class Q10 {
    static int V;
    static int E;

    static class Edge {
        int src, dest, w;

        Edge(int s, int d, int wt) {
            src = s;
            dest = d;
            w = wt;
        }
    }

    static Edge[] edges;
    int[] d;

    static class Graph {
        Graph(int v, int e) {
            V = v;
            E = e;
            edges = new Edge[E];
            for (int i = 0; i < E; i++) {
                edges[i] = new Edge(0, 0, 0);
            }
        }
    }

    void bellman(int sr) {
        d = new int[V];
        for (int i = 0; i < V; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[sr] = 0;
        boolean flag;
        for (int i = 0; i < V; i++) {
            flag = true;
            for (int j = 0; j < E; j++) {
                int u = edges[j].src, v = edges[j].dest;
                if (d[u] != Integer.MAX_VALUE && d[u] + edges[j].w < d[v]) {
                    d[v] = d[u] + edges[j].w;
                    flag = false;
                }
            }
            if (flag) {
                // The distance remained same as prev
                break;
            }
        }
        for (int j = 0; j < E; j++) {
            int u = edges[j].src, v = edges[j].dest;
            if (d[u] != Integer.MAX_VALUE && d[u] + edges[j].w < d[v]) {
                System.out.println("Negative cyc");
                return;
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(d[i]);
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(5, 8);
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        Q10 q10 = new Q10();
        q10.bellman(0);

    }

}
