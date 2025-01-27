class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        long low = 1;
        long high = (long) 1e14;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long tripsCovered = 0;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                tripsCovered += mid / time[i];
                if (tripsCovered >= totalTrips) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}