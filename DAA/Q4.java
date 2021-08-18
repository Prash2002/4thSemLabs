import java.util.Random;
import java.util.Scanner;

// Design and implement merge sort algorithm that takes random number input and displays
// the execution time required.

public class Q4 {
    void merge(int[] a, int f, int l) {
        int m = (f + l) / 2;
        int nl = m - f + 1;
        int nr = l - m;
        int[] left = new int[nl];
        int[] right = new int[nr];

        for (int i = f; i <= m; i++) {
            left[i - f] = a[i];
        }
        for (int i = m + 1; i <= l; i++) {
            right[i - m - 1] = a[i];
        }
        int i = 0, j = 0, k = f;

        while (i < nl && j < nr) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nl) {
            a[k] = left[i];
            i++;
            k++;
        }
        while (j < nr) {
            a[k] = right[j];
            j++;
            k++;
        }

    }

    void sort(int[] a, int st, int end) {
        if (st < end) {
            int m = (st + end) / 2;
            sort(a, st, m);
            sort(a, m + 1, end);

            merge(a, st, end);
        }
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        int n;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(500);
        }
        System.out.println("The array before sorting is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        long start = System.nanoTime();
        q4.sort(arr, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("\nTime taken by merge sort is " + (end - start) + " ns");

        System.out.println("The array after sorting is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
