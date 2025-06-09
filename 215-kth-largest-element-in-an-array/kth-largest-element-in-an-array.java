class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min Heap;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }

        return pq.poll();
    }
}