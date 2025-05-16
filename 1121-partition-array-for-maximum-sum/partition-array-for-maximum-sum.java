class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return f(arr, n, 0, k, memo);
    }

    private int f(int[] arr, int n, int i, int k, int[] memo) {
        if (i == n) return 0;
        if (memo[i] != -1) return memo[i];
        int max = Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE;
        int len = 0;
        for (int j = i; j < Math.min(i + k, n); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len * maxi + f(arr, n, j + 1, k, memo);
            max = Math.max(sum, max);
        }
        return memo[i] = max;
    }
}