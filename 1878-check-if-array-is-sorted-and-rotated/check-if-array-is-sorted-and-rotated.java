class Solution {
    public boolean check(int[] nums) {
        
        int drop = 0;
        int index = 0;
        int n = nums.length;

        if (n == 1) {
            return true;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                drop++;
                index = i;
            }
        }

        if (drop >= 2) {
            return false;
        }

        int ind = index;
        for (int i = 0; i < n - 1; i++) {
            if (nums[(ind + i) % n] > nums[(ind + i + 1) % n]) {
                return false;
            }
        }

        return true;
    }
}