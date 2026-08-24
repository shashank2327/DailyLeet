/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

        int res = -1;
        int u = 0;
        
        for (int i = 1; i < n; i++) {
            if (knows(u, i)) {
                res = i;
                u = i;
            } else {
                res = u;
            }
        }

        if (res == -1) return res;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (knows(i, res)) cnt++;

            if (i != res && knows(res, i)) cnt--;
        }

        return cnt == n ? res : -1;
    }
}