class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Maintain of deque of decreasing values;

        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {

            // If the first element is not in the window size then remove it;
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                result[idx] = nums[dq.peekFirst()];
                idx++;
            }
        }

        return result;
    }
}