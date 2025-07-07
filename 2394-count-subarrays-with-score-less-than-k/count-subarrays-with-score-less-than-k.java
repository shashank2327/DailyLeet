class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long score = 0;
        long sum = 0;
        int left = 0;
        int right = 0;
        long count = 0;
        while (right < n) {
            sum += nums[right];
            score = sum * (right - left + 1);
            while (score >= k && left <= right) {
                sum -= nums[left];
                left++;
                score = sum * (right - left + 1);
                
            }

            count += (right - left + 1);
            right++;
        }   

        return count;
    }
}