class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int p1 = 0;
        int p2 = 0;
        double[] res = new double[n + m];
        int idx = 0;
        while (p1 < n && p2 < m) {
            if (nums1[p1] <= nums2[p2]) {
                res[idx++] = (double)nums1[p1];
                p1++;
            } else {
                res[idx++] = (double)nums2[p2];
                p2++;
            }
        }

        while (p1 < n) {
            res[idx++] = (double)nums1[p1];
            p1++;
        }
        while (p2 < m) {
            res[idx++] = (double)nums2[p2];
            p2++;
        }

        if ((n + m) % 2 != 0) {
            return res[(n+m)/2];
        } else {
            return (res[(n + m) / 2] + res[(n + m)/2  - 1]) /2;
        }
    }
}