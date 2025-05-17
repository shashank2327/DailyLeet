class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int[][] dp = new int[n][3];
        for (int[] x : dp) Arrays.fill(x, -1);
        return f(events, 0, 2, dp);
    }

    private int f(int[][] events, int i, int k, int[][] dp) {
        if (k == 0 || i >= events.length) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        int notTake = f(events, i + 1, k, dp);
        int nextValid = binarySearch(events, events[i][1]);
        int take = events[i][2] + f(events, nextValid, k - 1, dp);
        return dp[i][k] = Math.max(take, notTake);
    }

    private int binarySearch(int[][] events, int val) {
        int l = 0;
        int r = events.length - 1;
        int result = events.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (events[mid][0] > val) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}
