class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();

        // making a changes table
        // for every substring how much changes req to make it palindrome;
        int[][] changes = new int[n][n]; 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substr  = s.substring(i, j + 1);
                changes[i][j] = calChanges(substr);
            }
        }
        int[][] memo = new int[k + 1][n];
        for (int[] x : memo) Arrays.fill(x, -1);
        return fun(s, 0, n, k, changes, memo);
    }

    private int fun(String s, int i, int n, int k, int[][] changes, int[][] memo) {
        // base cases.
        if (i != n && k <= 0) return (int)1e9;
        if (i == n) {
            if (k == 0) {
                return 0;
            } else {
                return (int)1e9;
            }
        }
        if (memo[k][i] != -1) return memo[k][i];

        int min = Integer.MAX_VALUE;
        for (int end = i; end < n; end++) {
            int mini = changes[i][end] + fun(s, end + 1, n, k - 1, changes, memo);
            min = Math.min(mini, min);
        }
        return memo[k][i] = min;
    }


    private int calChanges(String s) {
        int l = 0, r = s.length() - 1, cnt = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                cnt++;
            }
            l++;
            r--;
        }
        return cnt;
    }
}