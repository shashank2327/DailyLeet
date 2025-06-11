class Solution {
    private int[][] prefixFreq;

    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int[] x : memo) Arrays.fill(x, -1);
        
        prefixFreq = new int[n][26];
        prefixFreq[0][s.charAt(0) - 'a'] = 1;

        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                prefixFreq[i][c] = prefixFreq[i - 1][c];
            }
            prefixFreq[i][s.charAt(i) - 'a']++;
        }

        return fun(s, 0, n - 1, memo);
    }

    private int fun(String s, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            if (isBalanced(i, k)) {
                ans = Math.min(ans, 1 + fun(s, k + 1, j, memo));
            }
        }

        return memo[i][j] = ans;
    }

    private boolean isBalanced(int i, int j) {
        int[] freq = new int[26];

        for (int c = 0; c < 26; c++) {
            freq[c] = prefixFreq[j][c] - (i > 0 ? prefixFreq[i - 1][c] : 0);
        }

        int count = 0;
        for (int f : freq) {
            if (f > 0) {
                if (count == 0) count = f;
                else if (count != f) return false;
            }
        }

        return true;
    }
}
