class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];
        gaps[0] = startTime[0] - 0;
        System.out.println(Arrays.toString(gaps));
        int maxSum = 0;
        for (int i = 0; i <= k; i++) {
            maxSum += gaps[i];
        }
        int s = 0;
        int e = k + 1;
        int currentSum = maxSum;
        while (e <= n) {
            currentSum += (gaps[e] - gaps[s]);
            maxSum = Math.max(currentSum, maxSum);
            s++;
            e++;
        }

        return maxSum;
    }
}