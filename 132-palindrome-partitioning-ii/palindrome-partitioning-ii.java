class Solution {
    public int minCut(String s) {
        int n = s.length();
        // int[] memo = new int[n];
        // Arrays.fill(memo, -1);
        // return f(s, 0, memo) - 1;


        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = n - 1; j >= i; j--) {
                if (isPalindrome(s, i, j)) {
                    int cuts = 1 + dp[j + 1];
                    min = Math.min(min, cuts);
                }
            }
            dp[i] = min;
        }
        return dp[0] -1;
    }

/*------------------------memo + recur-----------------------------------------------------------*/    
    private int f(String s, int i, int[] memo) {
        if (i == s.length()) return 0;
        if (memo[i] != -1) return memo[i];
        int min = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                int cuts = 1 + f(s, j + 1, memo);
                min = Math.min(min, cuts);
            }
        } 
        return memo[i] = min;       
    }

    private boolean isPalindrome(String str, int i, int j) {
        int s = i;
        int e = j;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}