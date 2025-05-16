class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        List<Integer> ls = new ArrayList<>();
        for (int cut : cuts) {
            ls.add(cut);
        }

        ls.add(0);
        ls.add(n);
        Collections.sort(ls);
        // return f(1, c, ls);

        int[][] dp = new int[c + 2][c + 2];
        for (int[] x : dp) Arrays.fill(x, 0);
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;
                int min = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = ls.get(j + 1) - ls.get(i - 1) + dp[i][ind - 1] +
                            dp[ind + 1][j];
                    min = Math.min(min, cost); 
                }
                dp[i][j] = min;
            }
        }

        return dp[1][c];
    }

    private int f(int i, int j, List<Integer> ls) {
        if (i > j) return 0;

        int min = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int cost = ls.get(j + 1) - ls.get(i - 1) + f(i, ind - 1, ls) +
                        f(ind + 1, j, ls);
            min = Math.min(min, cost); 
        }

        return min;
    }
}