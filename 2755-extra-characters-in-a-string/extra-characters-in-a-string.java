class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(List.of(dictionary));
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return fun(s, 0, set, dp);
    }

    private int fun(String s, int start, Set<String> set, int[] dp) {
        if (start == s.length()) {
            return 0;
        }
        if (dp[start] != -1) return dp[start];

        int ans = Integer.MAX_VALUE;
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            // if the set contains then only we can take;
            if (set.contains(sub)) {
                ans = Math.min(ans, fun(s, end, set, dp));
            }
            ans = Math.min(ans, end - start + fun(s, end, set,dp));     
        }

        dp[start] = ans;
        return ans;
    }
}