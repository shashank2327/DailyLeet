class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] leftSum = new long[2 * n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sumLeft = 0;

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            sumLeft += nums[i];

            if (maxHeap.size() > n) {
                sumLeft -= maxHeap.poll();
            }

            if (maxHeap.size() == n) {
                leftSum[i] = sumLeft;
            }
        }

        long[] rightSum = new long[2 * n + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumRight = 0;

        for (int i = len - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            sumRight += nums[i];

            if (minHeap.size() > n) {
                sumRight -= minHeap.poll();
            }

            if (minHeap.size() == n) {
                rightSum[i] = sumRight;
            }
        }

        long result = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            long left = leftSum[i];
            long right = rightSum[i + 1];
            result = Math.min(result, left - right);
        }

        return result;
    }
}

/*
    3 * n elements;
    
    we will get minimum differnce when the sum1 <<< sum2
    so i need to decrease the sum1 and increase the sum2;

    7 9 5 8 1 3 4 6 2
*/