class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] diffArray = new int[n];  // This is a difference array
        for (int i = 0; i < n; i++) {
            diffArray[i] = nums[i] - target[i];
        }

        long cnt = Math.abs(diffArray[0]);
        for (int i = 1; i < n; i++) {
            boolean check = (diffArray[i] >= 0 && diffArray[i - 1] <= 0) || 
                                (diffArray[i] <= 0 && diffArray[i - 1] >= 0);

            if (check) {
                cnt += Math.abs(diffArray[i]);
            } else {
                if (diffArray[i] < 0) {
                    cnt += Math.max(diffArray[i - 1] - diffArray[i], 0);
                } else {
                    cnt += Math.max(diffArray[i] - diffArray[i - 1], 0);
                }
            }
        }

        return cnt;
    }
}

// The main idea is to make the differnce between the nums[i] and target[i] equal to 0;