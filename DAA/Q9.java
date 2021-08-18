import java.util.Scanner;

// Ravi is planning for a trekking expedition with a backpack that can hold 7kg. She needs to
// select the most valuable items from the following list that can be accommodated within the
// backpack.
// Design and implement an algorithm that displays the most valuable items that can be
// carried by him using Dynamic programming principles.

public class Q9 {
    static int W = 7;
    static int n = 4;

    static class Item {
        int weight, value;
    }

    static Item[] items;
    int[][] M;

    void knapsack() {
        M = new int[n + 1][W + 1];
        int i, j;
        for (i = 0; i <= n; i++) {
            M[i][0] = 0;
        }
        for (i = 0; i <= W; i++) {
            M[0][i] = 0;
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= W; j++) {
                if (items[i - 1].weight > j)
                    M[i][j] = M[i - 1][j];
                else {
                    M[i][j] = Math.max(M[i - 1][j], items[i - 1].value + M[i - 1][j - items[i - 1].weight]);
                }
            }
        }

        // System.out.println(M[n][W]);
        print();
    }

    void print() {
        int i = n, j = W;
        while (i > 0 && j > 0) {
            if (M[i][j] == M[i - 1][j]) {
                i--;
            } else {
                System.out.println(i);
                i--;
                j = j - items[i].weight;
            }
        }
    }

    public static void main(String[] args) {
        items = new Item[n];
        Q9 q9 = new Q9();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            items[i] = new Item();
            items[i].weight = sc.nextInt();
            items[i].value = sc.nextInt();
        }
        q9.knapsack();
    }

}
