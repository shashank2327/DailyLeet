class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int lo = 1;
        int hi = n;
        int max = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int[] res = maxSlidingWindow(chargeTimes, mid);
            long[] sum = windowSum(runningCosts, mid);
            // System.out.println(Arrays.toString(res));
            // System.out.println(Arrays.toString(sum));
            boolean flag = false;

            for (int i = 0; i < res.length; i++) {
                long cost = res[i] + mid * (sum[i]);

                if (cost <= budget) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                max = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return max;
    }

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


    public long[] windowSum(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[n - (k - 1)];
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        res[0] = sum;
        int l = 0;
        int r = k;
        int idx = 1;
        while (r < n) {
            sum += nums[r] - nums[l];
            res[idx] = sum;
            idx++;
            r++;
            l++;
        }
        return res;
    }
}

// binary Search approach ->
// minimum window size = 0;
// maximum window size = length of the array;
