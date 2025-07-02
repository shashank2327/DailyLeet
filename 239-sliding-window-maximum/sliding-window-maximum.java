class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();

        int[] res = new int[n - (k - 1)];
        int idx = 0;

        for (int i = 0; i < n; i++) {

            // If the top value of my deque is out of the window then get it out of the dq;
            while (!dq.isEmpty() && i - dq.peekFirst() >= k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);

            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}

// i - dq.peekFirst() > k + 1;