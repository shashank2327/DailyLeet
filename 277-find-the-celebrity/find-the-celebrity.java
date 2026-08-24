/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cnt = 0;
        int res = -1;

        for (int i = 0; i < n; i++) {
            int fans = 0;
            for (int j = 0; j < n; j++) {
                if (knows(j, i)) {
                    fans++;
                }

                if (i != j && knows(i, j)) {
                    fans--;
                }
            }

            if (fans == n) {
                cnt++;
                res = i;
            }
        }

        if (cnt == 1) {
            return res;
        } else {
            return -1;
        }
    }
}

/*
    the brute force approach is to,

    for every node, check whether every other node knows it or not;
*/