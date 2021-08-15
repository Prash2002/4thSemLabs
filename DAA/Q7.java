import java.util.Arrays;
import java.util.Scanner;

// A phone company wants to lay lines for communication in a city. Different amounts are
// charged for connecting between a pair of cities.
// Design and implement a greedy solution such that it forms a spanning tree with minimum
// cost.

//Krushkal

public class Q7 {
    static class Edge implements Comparable<Q7.Edge> {

        int src, dest, w;

        @Override
        public int compareTo(Q7.Edge o) {
            return w - o.w;
        }

    }

    static int V;
    static int E;
    static Edge[] edges;
    Edge[] result;

    static class node {
        int parent;
        int rank;
    }

    static node[] subset;

    static class Graph {
        Graph() {
            edges = new Edge[E];
            subset = new node[V];
            for (int i = 0; i < E; i++) {
                edges[i] = new Edge();
            }
            for (int i = 0; i < V; i++) {
                subset[i] = new node();
            }
        }
    }

    int find(int ind) {
        if (subset[ind].parent == -1)
            return ind;
        return subset[ind].parent = find(subset[ind].parent); // Path compression
    }

    void union(int s, int d) {
        int rankS = subset[s].rank, rankD = subset[d].rank;
        if (rankS > rankD) {
            subset[d].parent = s;
        }
        if (rankS < rankD) {
            subset[s].parent = d;
        }
        if (rankS == rankD) {
            subset[d].parent = s;
            subset[s].rank += 1;
        }
    }

    void Krushkal() {
        Arrays.sort(edges);

        int i = 0, j = 0;
        while (i < V - 1 && j < E) {
            int absParentSrc = find(edges[j].src);
            int absParentDest = find(edges[j].dest);

            if (absParentSrc == absParentDest) {
                // forms cycle
                j++;
            } else {
                union(absParentSrc, absParentDest);
                result[i] = edges[j];
                i++;
                j++;
            }
        }

    }

    void print() {
        System.out.println("The MST is: ");
        for (int i = 0; i < V - 1; i++) {
            Edge p = result[i];
            System.out.println(p.src + " " + p.dest + " " + p.w);
        }
    }

    public static void main(String[] args) {
        Q7 q7 = new Q7();

        System.out.println("Enter number of vertices and edges");
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        Graph graph = new Q7.Graph();

        q7.result = new Edge[V];

        for (int i = 0; i < V; i++) {
            Q7.subset[i].parent = -1;
            Q7.subset[i].rank = 0;
        }

        for (int i = 0; i < E; i++) {
            System.out.println("Enter edge " + (i + 1) + "'s source, destination and weight: ");
            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].w = sc.nextInt();
        }

        q7.Krushkal();
        q7.print();
    }
}
// INPUT

// Enter number of vertices and edges 4 5
// Enter edge 1's source, destination and weight:0 1 10
// Enter edge 2's source, destination and weight:0 2 6
// Enter edge 3's source, destination and weight:0 3 5
// Enter edge 4's source, destination and weight:1 3 15
// Enter edge 5's source, destination and weight:2 3 4

// OUTPUT:

// The MST is:
// 2 3 4
// 0 3 5
// 0 1 10