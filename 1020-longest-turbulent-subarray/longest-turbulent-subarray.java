class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        // does starting point matters whether it is -1 or 1 
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                dp[i] = -1;
            } else if (arr[i] > arr[i - 1]) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }


        int l = 0; 
        int r = 1;
        int max = 0;


        while (r < n) {
            if (dp[r] != 0) {
                if (dp[r] == dp[r - 1]) {
                    max = Math.max(max, r - l);
                    l = r - 1;
                    r++;
                } else {
                    r++;
                }
            } else if (dp[r] == 0) {
                max = Math.max(max, r - l);
                l = r;
                r++;
            }
        }

        max = Math.max(r - l, max);

        return max;
    }
}