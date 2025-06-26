class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int cnt = 0;
        int currValue = 0;
        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                cnt++;
                idx++;
            } else {
                if (currValue + Math.pow(2, idx) <= k) {
                    currValue += Math.pow(2, idx);
                    cnt++;
                    idx++;
                }
            }
        }


        return cnt;
    }
}