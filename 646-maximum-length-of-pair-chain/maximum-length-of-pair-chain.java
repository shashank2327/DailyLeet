class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int cur = -100001;
        for (int i = 0; i < n; i++) {
            if (cur < pairs[i][0]) {
                ans++;
                cur = pairs[i][1];
            }
        }

        return ans;
    }
}