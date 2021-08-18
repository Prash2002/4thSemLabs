import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* 
A GPS navigation system needs an approach to discover the reachable areas in a given
geographical region from a given source area. Design and implement an algorithm to find
which nodes can be reached from a given source node for the following graph.
*/

public class Q2 {
    LinkedList<Integer>[] adjLists;
    boolean[] visited;

    Q2(int n) {
        visited = new boolean[n];
        adjLists = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjLists[i] = new LinkedList<Integer>();
        }

    }

    void addEdge(int s, int d) {
        adjLists[s].add(d);
    }

    void bfs(int s) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println(s);
            Iterator<Integer> i = adjLists[s].listIterator();
            while (i.hasNext()) {
                int temp = i.next();
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.add(temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Q2 g = new Q2(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2);
    }
}
