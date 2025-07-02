
class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        // max-heap by chargeTime
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); 

        int left = 0, right = 0;
        long sum = 0;
        int maxSize = 0;

        while (right < n) {
            pq.offer(new int[]{chargeTimes[right], right}); // {chargeTime, index}
            sum += runningCosts[right];

            // Remove robots whose index is out of the current window
            while (!pq.isEmpty() && pq.peek()[1] < left) {
                pq.poll();
            }

            // Calculate cost
            long cost = !pq.isEmpty() ? pq.peek()[0] + (long)(right - left + 1) * sum : Long.MAX_VALUE;

            // Shrink window if over budget
            while (left <= right && cost > budget) {
                sum -= runningCosts[left];
                left++;
                while (!pq.isEmpty() && pq.peek()[1] < left) {
                    pq.poll();
                }
                cost = !pq.isEmpty() ? pq.peek()[0] + (long)(right - left + 1) * sum : Long.MAX_VALUE;
            }

            // Update max size of valid subarray
            maxSize = Math.max(maxSize, right - left + 1);
            right++;
        }

        return maxSize;
    }
}
