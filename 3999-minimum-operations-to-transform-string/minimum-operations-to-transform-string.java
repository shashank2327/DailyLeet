class Solution {
    public int minOperations(String s) {
        int ans = 0;
        for (char ch : s.toCharArray()) {
            int cnt = (26 - (ch - 'a')) % 26;
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}