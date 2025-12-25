class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long sum = 0;
        long token = 0;
        for (int i = n - 1; i >= n - k; i--) {
            long val = (long) Math.max(0, happiness[i] - token);
            sum += val;
            token++;
        }

        return sum;
    }
}

/*
    42 = 41
    12 - 1 = 1
    1 - 2 = -1 , 0
*/