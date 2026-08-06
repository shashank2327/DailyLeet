class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int o = 0;
            int e = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    e++;
                } else {
                    o++;
                }
                if (o > 0 & (e * b <= o * a)) ans++;
            }
        }

        return ans;
    }
}

/*
    x * b <= y * a
*/