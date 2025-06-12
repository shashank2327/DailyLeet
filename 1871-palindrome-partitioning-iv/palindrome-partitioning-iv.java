class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) {
                        isPalin[i][j] = true;
                    } else {
                        isPalin[i][j] = isPalin[i + 1][j - 1];
                    }
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (isPalin[0][i - 1] && isPalin[i][j] && isPalin[j + 1][n - 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
