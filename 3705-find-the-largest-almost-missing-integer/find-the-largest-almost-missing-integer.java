class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        int maxE = -1;
        for (int i = 0; i < n; i++) {
            maxE = Math.max(maxE, nums[i]); 
            freq[nums[i]] ++;
        }
        
        if (k == n) {
            return maxE;
        }
        if (k == 1) {
            int max = -1;
            for (int i = 0; i <= 50; i++) {
                if (freq[i] == 1) {
                    max = Math.max(i, max);
                }
            }
            return max;
        } else {
            int max = -1;
            if (freq[nums[0]] == 1) {
                max = Math.max(nums[0], max);
            }
            if (freq[nums[n - 1]] == 1) {
                max = Math.max(nums[n - 1], max);
            }
            return max;
        }
        
    }
}