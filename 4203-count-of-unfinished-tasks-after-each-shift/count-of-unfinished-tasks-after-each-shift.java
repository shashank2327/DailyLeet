class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;

        // Prefix sum must be long to avoid integer overflow
        long[] pref = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + tasks[i - 1];
        }

        int[] ans = new int[m];

        // j = current task
        int j = 0;

        // Remaining work of current task
        long rem = tasks[0];

        for (int i = 0; i < m; i++) {

            long supply = shifts[i];

            int idx = binarySearch(pref, tasks.length, supply, j, rem);

            // Work required to complete tasks j ... idx-1
            long used = rem + pref[idx] - pref[j + 1];

            if (idx == n) {
                // All tasks completed during this shift.
                ans[i] = 0;

                // Next shift starts again from task 0
                j = 0;
                rem = tasks[0];
            } else {
                // idx is the task currently in progress.
                long extra = supply - used;

                j = idx;
                rem = tasks[j] - extra;

                // Current task is also unfinished
                ans[i] = n - j;
            }
        }

        return ans;
    }

    private int binarySearch(long[] pref, int n,
                             long target, int j, long rem) {

        int lo = j + 1;
        int hi = n;

        // If current task cannot be completed,
        // no task gets completed.
        int idx = j;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // Work required to complete tasks j ... mid-1
            long required = rem + pref[mid] - pref[j + 1];

            if (required <= target) {
                idx = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return idx;
    }
}