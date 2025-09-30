class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                int val = (nums[j - 1] + nums[j])%10;
                nums[j - 1] = val;
            }
        }

        return nums[0];
    }
}

/*
    3 5 7 9 5 
    8 
*/