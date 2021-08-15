import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args) {
        // int[][] mensPreference = { { 2, 1, 3, 4 }, { 3, 4, 2, 1 }, { 1, 2, 4, 3 }, {
        // 4, 3, 1, 2 }, };
        // int[][] womensPreference = { { 1, 2, 3, 4 }, { 3, 1, 2, 4 }, { 1, 2, 4, 3 },
        // { 2, 3, 4, 1 }, };

        // int[][] mensPreference = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, {
        // 1, 2, 3, 4 }, };
        // int[][] womensPreference = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 },
        // { 1, 2, 3, 4 } };

        int[][] mensPreference = { { 3, 2, 5, 1, 4 }, { 1, 2, 5, 3, 4 }, { 4, 3, 2, 1, 5 }, { 1, 3, 4, 2, 5 },
                { 1, 2, 4, 5, 3 } };
        int[][] womensPreference = { { 3, 5, 2, 1, 4 }, { 5, 2, 1, 4, 3 }, { 4, 3, 5, 1, 2 }, { 1, 2, 3, 4, 5 },
                { 2, 3, 4, 1, 5 } };
        int i, j, n = 5;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean mFree[] = new boolean[n];
        int freeCount = n;
        while (freeCount > 0) {
            int m;
            for (m = 0; m < n; m++) {
                if (mFree[m] == false)
                    break;
            }
            i = m;
            for (j = 0; j < n && mFree[i] == false; j++) {
                int womenChoosen = mensPreference[i][j];
                int womansHubby = map.getOrDefault(womenChoosen, -1);
                if (womansHubby == -1) {
                    // woman not yet married to anyone
                    map.put((womenChoosen), (i + 1));
                    System.out.println("women " + (womenChoosen) + " married to " + (i + 1) + " man");
                    mFree[i] = true;
                    freeCount--;
                    break;

                } else {
                    // woman married
                    int[] womansList = womensPreference[womenChoosen - 1];
                    int currentManIndex = 0, husbandIndex = 0;
                    for (int k = 0; k < n; k++) {
                        if (womansHubby == womansList[k]) {
                            husbandIndex = k;
                        }
                        if (i + 1 == womansList[k]) {
                            currentManIndex = k;
                        }
                    }
                    if (currentManIndex < husbandIndex) {
                        // woman divorces with husband and marries current man
                        System.out.println("women " + (womenChoosen) + " divorced to " + womansHubby + " man");
                        mFree[womansHubby - 1] = false;
                        map.remove(womenChoosen);
                        map.put((womenChoosen), (i + 1));
                        System.out.println("women " + (womenChoosen) + " married to " + (i + 1) + " man");
                        mFree[i] = true;
                        break;
                    }
                    // remains as it is
                }

            }
        }

        System.out.println(map);
    }
}
