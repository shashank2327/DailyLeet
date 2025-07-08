class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(s, 0, memo);
    }

    public int solve(String s, int idx, int[] memo) {
        if (idx == s.length()) {
            return 1;
        }
        if (s.charAt(idx) == '0') {
            return 0;
        }
        if (memo[idx] != -1) return memo[idx];
        int ans = 0;

        // i = idx -> idx + 2; because maximum 2 digit numbers can be used;
        for (int i = idx; i < Math.min(idx + 2, s.length()); i++) {
            String sub = s.substring(idx, i + 1);
            int value = Integer.parseInt(sub);
            if (value > 0 && value <= 26) {
                ans += solve(s, i + 1, memo);
            }
        }

        return memo[idx] = ans;
    }
}

