import java.util.Arrays;

// A drama venue needs to be allocated for different drama school requests such that
// maximum profit is obtained for the company owning the drama venue. The requests are
// shown in the table with start –time, finish-time and the amount affordable by the drama
// school. Design and implement an algorithm such that maximum profit is obtained for the
// company owning the drama venue.

public class Q8 {
    static class Job implements Comparable<Job> {
        int st, ft, w;

        public int compareTo(Job o) {
            return ft - o.ft;
        }
    }

    Job[] jobs;
    int n = 4;
    int[] p;
    int[] m;

    int binarySearch(int i) {
        int start = jobs[i].st;
        int low = 1, high = i;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (jobs[mid].ft <= start) {
                if (jobs[mid + 1].ft > start)
                    return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    void findPredecessor() {
        p = new int[n + 1];
        p[0] = 0;
        p[1] = 0;
        for (int i = 2; i <= n; i++) {
            p[i] = binarySearch(i);
            // System.out.println(p[i]);
        }
    }

    void WeigtedInterval() {
        int temp = 0;
        m = new int[n + 1];
        m[0] = 0;
        for (int j = 1; j <= n; j++) {

            m[j] = Math.max(jobs[j].w + m[p[j]], m[j - 1]);

            // System.out.println(m[j]);
        }
    }

    void find_solution(int j) {
        int temp;
        if (j > 0) {

            if (jobs[j].w + m[p[j]] > m[j - 1]) {
                System.out.println(j);
                find_solution(p[j]);
            } else
                find_solution(j - 1);
        }
    }

    public static void main(String[] args) {
        Q8 q8 = new Q8();
        q8.jobs = new Job[5];

        for (int i = 0; i < 5; i++) {
            q8.jobs[i] = new Job();
        }

        q8.jobs[0].st = 0;
        q8.jobs[0].ft = 0;
        q8.jobs[0].w = 0;

        q8.jobs[4].st = 0;
        q8.jobs[4].ft = 2;
        q8.jobs[4].w = 10;

        q8.jobs[1].st = 1;
        q8.jobs[1].ft = 5;
        q8.jobs[1].w = 3;

        q8.jobs[3].st = 4;
        q8.jobs[3].ft = 6;
        q8.jobs[3].w = 4;

        q8.jobs[2].st = 7;
        q8.jobs[2].ft = 8;
        q8.jobs[2].w = 2;

        Arrays.sort(q8.jobs);

        // for (int i = 0; i < 4; i++) {
        // System.out.print(q8.jobs[i].st);
        // System.out.print(q8.jobs[i].ft);
        // System.out.println(q8.jobs[i].w);
        // }

        q8.findPredecessor();
        q8.WeigtedInterval();
        q8.find_solution(q8.n);

    }
}
