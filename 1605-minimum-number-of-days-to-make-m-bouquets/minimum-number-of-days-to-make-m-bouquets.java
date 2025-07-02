class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length; // number of flowers;

        // if number of flowers is less than the required flowers, return -1;
        if (n < m * k) {
            return - 1;
        }

        // binary Search;
        int low = 1; // minimum day, in which a flower blooms
        int high = (int)1e9; // maximum day, in which a flower blooms;

        int minDays = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, m, k, mid)) {
                minDays = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minDays;
    }

    public boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int n = bloomDay.length;
        int bouquetsMade = 0;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                bouquetsMade += count / k;
                count = 0;
            }
        }

        bouquetsMade += count/k;

        if (bouquetsMade >= m) {
            return true;
        } else {
            return false;
        }
    }
}


// 7 7 7 7 12 7  7