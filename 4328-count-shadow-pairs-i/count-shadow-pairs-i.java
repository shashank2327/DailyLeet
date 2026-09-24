class Solution {
    public long shadowPairs(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        long cnt = 0;

        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.push(nums[i]);
            } else if (st.peek() <= nums[i]) {
                st.push(nums[i]);
            } else {
                int prev = Integer.MAX_VALUE;
                int prevCnt = 0;
                int popped = 0;
                while (!st.isEmpty() && st.peek() > nums[i]) {
                    int val = st.pop();
                    if (val < prev) {
                        prevCnt = popped;
                    }

                    cnt += prevCnt;
                    prev = val;
                    popped++;
                }
                int currSize = st.size();
                cnt += popped * currSize;
                st.push(nums[i]);
            }
        }

        int prev = Integer.MAX_VALUE;
        int prevCnt = 0;
        int popped = 0;
        while (!st.isEmpty()) {
            int val = st.pop();
            if (val < prev) {
                prevCnt = popped;
            }

            cnt += prevCnt;
            prev = val;
            popped++;
        }

        return cnt;
    }
}

/*
    for a particular i check what all j exist such that nums[j] > nums[i]
    and there does not exist k such that nums[k] < nums[i];

    finding the next smaller element;

*/