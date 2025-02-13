class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (var num : nums) {
            pq.add((long) num);
        }

        if (pq.size() > 0 && pq.peek() >= k) {
            return 0;
        }

        int ans = 0;
        while (pq.size() >= 2) {
            if (pq.peek() >= k) return ans;
            ans++;
            long x = pq.poll();
            long y = pq.poll();
            long num = Math.min(x, y) * 2 + Math.max(x, y);
            pq.add(num);
        }
        return ans;

    }
}