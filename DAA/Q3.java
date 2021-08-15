import java.util.Iterator;
import java.util.LinkedList;

// A rat is searching for cheese in a maze that consists of nodes and edges as shown in the
// fig. It always goes deep into the maze, if it hits a wall then it returns back to the ancestor
// node and searches further. Suggest which algorithm can be chosen for it.

public class Q3 {
    LinkedList<Integer>[] adjList;
    boolean[] visited;

    Q3(int n) {
        adjList = new LinkedList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    void DFS(int s) {
        System.out.println(s);
        visited[s] = true;
        Iterator<Integer> i = adjList[s].listIterator();
        while (i.hasNext()) {
            int adj = i.next();
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3(4);
        q3.addEdge(0, 1);
        q3.addEdge(0, 2);
        q3.addEdge(1, 3);
        q3.addEdge(2, 3);

        q3.DFS(0);
    }
}