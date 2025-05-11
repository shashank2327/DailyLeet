class Solution {
    public boolean canPartitionGrid(int[][] grid) {


        
        long sum = 0;
        int n = grid.length;
        int m = grid[0].length;


        if (n == 1) {
            long s = 0;
            long ts = 0;
            for (int j = 0; j < m; j++) {
                ts += grid[0][j];
            }

            for (int j = 0; j < m - 1; j++) {
                s += grid[0][j];
                if (s == ts - s) return true;
                long remain = Math.abs(ts - (2 * sum));
                if (s > ts - sum) {
                    if (grid[0][0] == remain || grid[0][j] == remain) return true;
                } else {
                    if (grid[0][j + 1] == remain || grid[0][m - 1] == remain) return true;
                }
            }
            return false;
        }
        if (m == 1) {
            long s = 0;
            long ts = 0;
            for (int i = 0; i < n; i++) {
                ts += grid[i][0];
            }

            for (int i = 0; i < n - 1; i++) {
                s += grid[i][0];
                if (s == ts - s) return true;
                long remain = Math.abs(ts - (2 * s));
                if (s > ts - s) {
                    if ((long)grid[0][0] == remain || (long)grid[i][0] == remain) return true;
                } else if (s < ts - s){
                    if ((long)grid[i + 1][0] == remain || (long)grid[n - 1][0] == remain) return true;
                }
            }
            return false;
        }
        Map<Long, Integer> sh = new HashMap<>();
        Map<Long, Integer> sh2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += grid[i][j];
                sh.put((long) grid[i][j], sh.getOrDefault((long)grid[i][j], 0) + 1);
                sh2.put((long) grid[i][j], sh2.getOrDefault((long)grid[i][j], 0) + 1);
            }
        }


        // horizontal cut;

        long hsum = 0;
        Map<Long, Integer> fh = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                hsum += grid[i][j];
                fh.put((long) grid[i][j], fh.getOrDefault((long)grid[i][j], 0) + 1);
                if (sh.containsKey((long)grid[i][j]) && sh.get((long)grid[i][j]) > 0) {
                    sh.put((long) grid[i][j], sh.get((long)grid[i][j]) - 1);
                }
            }
            if (hsum == sum - hsum) {
                return true;
            }
            long remain = (long) Math.abs(sum - (2 * hsum));
            if (hsum > sum - hsum) {
                if (i == 0 && (grid[0][0] == remain || grid[0][m - 1] == remain)) {
                    return true;
                }
                if (i > 0 && fh.containsKey(remain) && fh.get(remain) > 0) return true;

            } else if (hsum < sum - hsum) {
                if (i == n - 2 && (grid[n - 1][0] == remain || grid[n - 1][m - 1] == remain)) {
                    return true;
                }
                if (i < n - 2 && sh.containsKey(remain) && sh.get(remain) > 0) return true;

            }
        }

        long vsum = 0;
        fh.clear();
        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                vsum += grid[i][j];
                fh.put((long) grid[i][j], fh.getOrDefault((long)grid[i][j], 0) + 1);
                if (sh2.containsKey((long)grid[i][j]) && sh2.get((long)grid[i][j]) > 0) {
                    sh2.put((long) grid[i][j], sh2.get((long)grid[i][j]) - 1);
                }
            }
            if (vsum == sum - vsum) {
                return true;
            }
            long remain = (long) Math.abs(sum - (2 * vsum));
            if (vsum > sum - vsum) {
                if (j == 0 && (grid[0][0] == remain || grid[n - 1][0] == remain)) {
                    return true;
                }
                if (j > 0 && fh.containsKey(remain) && fh.get(remain) > 0) return true;
            } else if (vsum < sum - vsum) {
                if (j == m - 2 && (grid[0][m - 1] == remain || grid[n - 1][m - 1] == remain)) {
                    return true;
                }
                if (j < m- 2 && sh2.containsKey(remain) && sh2.get(remain) > 0) return true;

            }
        }

        return false;
    }
}