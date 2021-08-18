import java.util.*;

// In a database of numbers there is a table of unsorted numbers. The database admin now
// wants to sort these numbers using an approach wherein a pivot element is selected for
// sorting. At certain point, the first half elements are less than the pivot and right half
// elements are greater than the pivot.
// Design and implement an algorithm to solve it using random numbers and also display the
// execution time.

public class Q5 {
    int partition(int[] a, int s, int e) {
        int pivot = a[e];
        int p = s;
        int temp;
        for (int j = s; j < e; j++) {
            if (a[j] < pivot) {
                if (j != p) {
                    temp = a[p];
                    a[p] = a[j];
                    a[j] = temp;
                }
                p++;
            }
        }
        temp = a[p];
        a[p] = a[e];
        a[e] = temp;
        return p;
    }

    void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }

    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
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
        q5.quickSort(arr, 0, n - 1);
        long end = System.nanoTime();
        System.out.println("\nTime taken by merge sort is " + (end - start) + " ns");

        System.out.println("The array after sorting is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
