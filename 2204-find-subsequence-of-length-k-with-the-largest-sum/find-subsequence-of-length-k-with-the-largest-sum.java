class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) {
                pq.poll();
            }
        }        

        // value and index;

        PriorityQueue<int[]> indexSorted = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        while (!pq.isEmpty()) {
            indexSorted.offer(pq.poll());
        }

        int[] result = new int[k];
        int idx = 0;
        while (idx < k) {
            result[idx++] = indexSorted.poll()[0];
        }

        return result;
    }
}