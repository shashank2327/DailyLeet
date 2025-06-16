class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return n;
        } else if (n == 2) {
            if (nums[0] != nums[1]) {
                return 2;
            } else {
                return 1;
            }
        }
        int i = 0;
        int prev = 0;
        while (i < n - 1) {
            if (nums[i + 1] != nums[i]) {
                prev = nums[i + 1] - nums[i];
                break;
            }
            i++;
        }

        if (i == n - 1) {
            return 1;
        }

        int cnt = 0;
        i += 2;

        while (i < n) {
            int curr = nums[i] - nums[i - 1];
            if ((curr > 0 && prev < 0) || (curr < 0 && prev > 0)) {
                prev = curr;
                cnt++;
            }
            i++;
        }
        
        return cnt + 2;
        // return 0;
    }
}