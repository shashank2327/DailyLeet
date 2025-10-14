class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int len = nums.size();
        if (len < 2 * k) return false;
        if (k == 1) return true;

        for (int i = 0; i <= len - 2 * k; i++) {
            boolean firstSubarray = check(nums, i, k);
            if (firstSubarray && check(nums, i + k, k)) return true;
        }

        return false;
    }

    private boolean check(List<Integer> nums, int idx, int k) {
    
        for (int i = idx + 1; i < idx + k; i++) {
            if (nums.get(i) <= nums.get(i - 1)) return false;
        }
        return true;
    }
}