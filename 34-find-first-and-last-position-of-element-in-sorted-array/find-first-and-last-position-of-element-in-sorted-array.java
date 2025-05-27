class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = lowerbound(nums, target);
        if (start == -1) return new int[] {-1, -1};

        int end = upperbound(nums, target);

        return new int[] {start, end - 1};
    }
    private int lowerbound(int[] nums, int x) {
        int l = 0,  r = nums.length - 1,  res = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == x) {
                res = m;
                r = m - 1;
            } else if (nums[m] > x) {
                r = m - 1;
            }
            
             else {
                l = m + 1;
            }
        }

        return res;
    }

    private int upperbound(int[] nums, int x) {
        int l = 0, r = nums.length - 1,  res = nums.length;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > x) {
                res = m;
                r = m - 1; 
            } else {
                l = m + 1;
            }
        }

        return res;
    }
}