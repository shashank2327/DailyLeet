class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;

        int MAX_N = (int)2e5 + 1;
        long[] memo = new long[MAX_N];
        Arrays.fill(memo, -1);

        return solve(questions, 0, n, memo);
    }

    // every time I have two options either to select or not to select.
    // Lets Memoise this.

    public long solve(int[][] a, int i, int n, long[] memo) {
        if (i >= n) {
            return 0;
        }
        if (memo[i] != -1) return memo[i];

        long case1 = a[i][0] + solve(a, i + a[i][1] + 1, n, memo);
        long case2 = solve(a, i + 1, n, memo);

        memo[i] = Math.max(case1, case2);
        return memo[i];
    }
}