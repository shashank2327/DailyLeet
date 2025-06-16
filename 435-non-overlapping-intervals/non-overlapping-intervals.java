class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cnt = 0;
        int prev = -(int)1e9;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= prev) {
                cnt++;
                prev = intervals[i][1];
            }
        }
        return n - cnt;
    }
    // private int maxSubseq(
    //     int[][] intervals,
    //     int i,
    //     int j
    // )
    // {
    //     if (i == intervals.length) {
    //         return 0;
    //     }

    //     int ans = Integer.MIN_VALUE;
    //     if (j == -1) {
    //         ans = Math.max(ans, 1 + maxSubseq(intervals, i + 1, i));
    //     } else if (intervals[i][0] >= intervals[j][1]){
    //         ans = Math.max(ans, 1 + maxSubseq(intervals, i + 1, i));
    //     }

    //     ans = Math.max(ans, maxSubseq(intervals, i + 1, j));

    //     return ans;
    // }
}

/*
    min no of intervals i need to remove in order to make the rest interval non- overlapping
    -> Transforming the question
    max non-overlapping subsequence;
*/