class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        if (n % 2 == 0 && m % 2 == 0) {
            return 0;
        } else if (n % 2 != 0 && m % 2 == 0) {
            for (int num : nums2) {
                ans = ans ^ num;
            }
        } else if (n % 2 == 0 && m % 2 != 0) {
            for (int num : nums1) {
                ans = ans ^ num;
            }
        } else {
            for (int num : nums2) {
                ans = ans ^ num;
            }
            for (int num : nums1) {
                ans = ans ^ num;
            }
        }

        return ans;
    }
}