class Solution {
    public int minimumSubstringsInPartition(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for (int[] x : memo) Arrays.fill(x, -1);
        return fun(s, 0, s.length() - 1, memo);
    }
    private int fun(String s, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != -1) return memo[i][j];
        int ans = Integer.MAX_VALUE;
        int[] freq = new int[26];
        for (int k = i; k <= j; k++) {
            // String str = s.substring(i, k + 1);
            freq[s.charAt(k) - 'a']++;
            if (check(freq)) {
                ans = Math.min(ans, 1 + fun(s, k + 1, j, memo));
            }
        }

        return memo[i][j] = ans;
    }

    private boolean check(int[] freq) {
        int max = 0;
        int min = 1001;
        for (int num : freq) {
            if (num > 0) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }

        return max == min;
    }
}