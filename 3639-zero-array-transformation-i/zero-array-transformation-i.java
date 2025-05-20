class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] sumA = new int[n];
        boolean ans = true;
        for (int i = 0; i < m; i++) {
            int sIndex = queries[i][0];
            int eIndex = queries[i][1];
            sumA[sIndex] += -1;
            if (eIndex != n - 1) {
                sumA[eIndex + 1] += 1;
            }
        }
        for (int i = 1; i < n; i++) {
            sumA[i] += sumA[i-1];
        }
        for (int i = 0; i < n; i++) {
            nums[i] += sumA[i];
            if (nums[i] > 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}