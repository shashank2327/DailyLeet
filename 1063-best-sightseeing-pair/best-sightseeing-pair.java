class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = Integer.MIN_VALUE;
        int val1 = values[0];

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, val1 + values[i] - i);
            val1 = Math.max(val1, values[i] + i);
        }
        return ans;
    }
}