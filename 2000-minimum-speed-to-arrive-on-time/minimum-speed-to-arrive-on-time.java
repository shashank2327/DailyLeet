class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int min = 1;
        int max = 10000000;
        int ans = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            double sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.ceil( ( (double) dist[i]) / mid);
            }
            sum = sum +  ( (double) dist[n-1]) /mid;
            if (sum > hour) {
                min = mid + 1;
            } else {
                ans = mid;
                max = mid - 1;
            }
        }
        return ans;
    }
}