class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || n % k != 0) return false;

        int maxRepetition = n / k;
        Arrays.sort(nums);

        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                if (cnt > maxRepetition) return false;
                cnt = 1;
            }
        }

        if (cnt > maxRepetition) return false;

        return true;
    }
}