class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int max = 0;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                int prevInd = map.getOrDefault(diff, -1);

                if (diff < arr[j] && prevInd >= 0) {
                    dp[j][i] = dp[prevInd][j] + 1;
                } else {
                    dp[j][i] = 2;
                }
                max = Math.max(max, dp[j][i]);
            }
        }

        return max > 2 ? max : 0;
    }
}