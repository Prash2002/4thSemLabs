// A truck driver is given a set of locations to be covered with their distances by a company.
// The company strictly orders that truck should be started from a particular location.
// Design and implement an algorithm that gives a greedy solution to the truck driver’s
// problem and display the shortest path for a given source location to all other locations.

// dijkstra

public class Q6 {
    static int[][] graph;
    static boolean visited[];
    static int ans[];
    static int n = 9;

    int findMin() {
        int mini = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (ans[i] < min && !visited[i]) {
                mini = i;
                min = ans[i];
            }
        }
        return mini;
    }

    void dijkstra(int src) {
        visited = new boolean[n];
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            ans[i] = Integer.MAX_VALUE;
        }
        ans[src] = 0;
        int count = 0;
        int u;
        while (count < n - 1) {

            u = findMin();
            // System.out.println(u);
            visited[u] = true;
            for (int i = 0; i < n; i++) {
                if (ans[u] + graph[u][i] < ans[i] && graph[u][i] != 0 && !visited[i]) {
                    ans[i] = ans[u] + graph[u][i];
                }
            }

            count++;
        }

    }

    public static void main(String[] args) {
        graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        Q6 q6 = new Q6();
        q6.dijkstra(0);
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + ans[i]);
        }
    }

}
