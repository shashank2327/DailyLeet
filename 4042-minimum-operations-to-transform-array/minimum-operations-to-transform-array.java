class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int last = Integer.MAX_VALUE;
        long cost = 0;
        int val = nums2[n];

        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];
            cost += Math.abs(a - b);

            // nums2[n] is in between a an b 
            if ((a <= val && val <= b) || (b <= val && val <= a)) {
                last = 0;
            } else {
                int minVal = Math.min(Math.abs(a - val), Math.abs(b - val));
                last = Math.min(last, minVal);
            }
        }

        return cost + last + 1;
    }
}