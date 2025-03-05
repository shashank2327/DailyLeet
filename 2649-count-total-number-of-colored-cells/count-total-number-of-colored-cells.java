class Solution {

    // 1, 5, 13, 25, 41, 61, 85
    public long coloredCells(int n) {
        if (n == 1) return 1;
        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans += 4 * i;
        }
        return ans;
    }
}