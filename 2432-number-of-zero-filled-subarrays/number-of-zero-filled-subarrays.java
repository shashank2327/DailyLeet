class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long result = 0;
        long count = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                result += ((count + 1) * count) / 2;
                count = 0;
            }
        }

        result += ((count + 1) * count) / 2;
         
        return result;
    }
}