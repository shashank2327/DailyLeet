class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long leftProduct = 1;
        long rightProduct = 1;

        long max = Integer.MIN_VALUE; //  keeps track of max so far;

        for (int i = 0; i < n; i++) {
            if (leftProduct == 0) {
                leftProduct = 1;
            }

            if (rightProduct == 0) {
                rightProduct = 1;
            }

            leftProduct *= nums[i];
            rightProduct *= nums[n - i - 1];

            max = Math.max(max, Math.max(leftProduct, rightProduct));
        }

        return (int)max;
    }
}