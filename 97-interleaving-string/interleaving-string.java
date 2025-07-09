class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(s1, s2, s3, 0, 0, 0, memo);
    }
    public boolean solve(String s1, String s2, String s3, int i, int j , int k, int[][] memo) {
        if (k == s3.length()) {
            if (i != s1.length() || j != s2.length()) {
                return false;
            }
            return true;
        }
        if (i < s1.length() && j < s2.length() && s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) {
            return false;
        }

        if (memo[i][j] != -1) {
            return memo[i][j] == 1 ? true : false;
        }

        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = result || solve(s1, s2, s3, i + 1, j, i + j + 1, memo);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = result || solve(s1, s2, s3, i, j + 1, i + j + 1, memo);
        }


        memo[i][j] = result == true ? 1 : 0;
        return result;
    }
}

// |n - m| <= 1 is only to confuse; there is no use of that