class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] schedule = new int[n][3];
        for (int i = 0; i < n; i++) {
            schedule[i][0] = startTime[i];
            schedule[i][1] = endTime[i];
            schedule[i][2] = profit[i];
        }
        Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));
        
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return f(schedule, 0, memo);
    }

    private int f(int[][] schedule, int i, int[] memo) {
        // base case;
        if (i >= schedule.length) return 0;
        if (memo[i] != -1) return memo[i];

        //two options -> take or not take
        int notTake = f(schedule, i + 1, memo);

        int validIndex = binarySearch(schedule, schedule[i][1]);
        int take = schedule[i][2] + f(schedule, validIndex, memo);

        return memo[i] =  Math.max(take , notTake);
    }

    int binarySearch(int[][] mat, int val) {
        int l = 0;
        int h = mat.length - 1;
        int result = mat.length;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (mat[m][0] >= val) {
                result = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }
}