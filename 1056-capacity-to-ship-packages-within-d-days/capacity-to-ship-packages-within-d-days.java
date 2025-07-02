class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 1;
        int hi = (int) 1e9;

        int result = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (possible(weights, mid, days)) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }

    public boolean possible(int[] weights, int capacity, int days) {
    int cnt = 1; // At least one day is required
    int sum = 0;

    for (int weight : weights) {
        if (weight > capacity) return false; // Can't ship this weight at all

        if (sum + weight > capacity) {
            cnt++;
            sum = 0;
        }
        sum += weight;
    }

    return cnt <= days;
}
}