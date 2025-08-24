class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];


        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i- 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }

        int[] result = new int[n];

        result[n - 1] = prefix[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            result[i] = prefix[i];
            if (prefix[i] > suffix[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1]);
            }
        }

        return result;
    }
}