class Solution {
    public int minimumSubstringsInPartition(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return fun(s, 0, s.length() - 1, memo);
    }
    private int fun(String s, int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) {
            return 1;
        }
        if (memo[i] != -1) return memo[i];
        int ans = Integer.MAX_VALUE;
        int[] freq = new int[26];
        for (int k = i; k <= n; k++) {
            // String str = s.substring(i, k + 1);
            freq[s.charAt(k) - 'a']++;
            if (check(freq)) {
                ans = Math.min(ans, 1 + fun(s, k + 1, n, memo));
            }
        }

        return memo[i] = ans;
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