class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] charArr = s.toCharArray();
        int[][] memo = new int[s.length() + 1][3];
        for (int[] x : memo) Arrays.fill(x, -1);
        return fun(charArr, 0, '2', memo);
    }
    private int fun(char[] s, int curr, char prevChar, int[][] memo) {
        if (curr == s.length) {
            return 0;
        }
        if (memo[curr][prevChar - '0'] != -1) return memo[curr][prevChar - '0'];
        int ans = Integer.MAX_VALUE;
        if (s[curr] == '0') {
            if (prevChar == '2' || prevChar == '0') {
                int flip = 1 + fun(s, curr + 1, '1', memo);
                int notflip = fun(s, curr + 1, '0', memo);
                ans = Math.min(ans, Math.min(flip, notflip));
            } else if (prevChar == '1') {
                int flip = 1 + fun(s, curr + 1, '1', memo);
                ans = Math.min(ans, flip);
            }
        } else {
            if (prevChar == '2' || prevChar == '0') {
                int flip = 1 + fun(s, curr + 1, '0', memo);
                int notflip = fun(s, curr + 1, '1', memo);
                ans = Math.min(ans, Math.min(flip, notflip));
            } else {
                int notflip = fun(s, curr + 1, '1', memo); 
                ans = Math.min(ans, notflip);
            }
        }
        return memo[curr][prevChar - '0'] = ans;
    }
}