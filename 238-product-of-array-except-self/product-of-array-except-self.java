class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        boolean isZero = false;
        int zeroCount = 0;
        int ind = -1;
        for (int num : nums) {
            if (num == 0) {
                isZero = true;
                zeroCount++;
            }
        }

        int product = 1;
        for (int num : nums) {
            if (num != 0) {
                product *= num;
            }
        }

        if (isZero) {
            if (zeroCount > 1) {
                Arrays.fill(nums, 0);
            } else {
                for (int i = 0; i < n; i++) {
                    if (nums[i] != 0) {
                        nums[i] = 0;
                    } else {
                        nums[i] = product;                    }
                }
            }
        } else {
            for (int i = 0; i < n;  i++) {
                nums[i] = product / nums[i];
            }
        }

        return nums;
    }
}