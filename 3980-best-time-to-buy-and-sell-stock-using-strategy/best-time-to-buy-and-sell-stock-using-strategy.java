class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long max = 0;
        long sum = 0;
        long[] prefix1 = new long[n];
        for (int i = 0; i < n; i++) {
            sum += (prices[i] * strategy[i]);
            prefix1[i] = sum;
        }
        max = sum;

        long[] prefix2 = new long[n];
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += prices[i];
            prefix2[i] = sum;
        }

        int left = 0;
        int right = k - 1;

        while (right < n) {
            long currSum = prefix2[right] - prefix2[left + (k / 2) - 1];
            long rightSum = prefix1[n - 1] - prefix1[right];
            long leftSum = 0;
            if (left != 0) {
                leftSum = prefix1[left - 1];
            }

            max = Math.max(max, leftSum + currSum + rightSum);
            left++;
            right++;
        }

        return max;
    }
}