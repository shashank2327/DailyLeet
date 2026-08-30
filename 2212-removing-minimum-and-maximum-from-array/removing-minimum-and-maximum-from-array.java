class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = 0;

        int min = nums[0];
        int max = nums[0];

        for (int k = 1; k < n; k++) {
            if (nums[k] < min) {
                min = nums[k];
                i = k;
            }

            if (nums[k] > max) {
                max = nums[k];
                j = k;
            }
        }

        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        /*case1*/
        int val1 = j + 1;
        int val2 = n - i;

        int val3 = i + 1 + n - j;

        return Math.min(val1, Math.min(val2, val3));
    }
}