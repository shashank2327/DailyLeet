class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            int idx = binarySearch(intervals, e);

            ans += (idx - i);
        }

        return ans;
    }

    private int binarySearch(int[][] mat, int tar) {
        int lo = 0;
        int hi = mat.length - 1;

        int res = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mat[mid][0] <= tar) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }
}

/*
    1 5
    2 4
    3 6

*/