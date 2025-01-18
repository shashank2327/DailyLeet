class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        // Array need to sorted
        int n = arr.length;
        long val2 = 0;
        for (int i = 0; i < n; i++) {
            val2 += Math.abs(arr[i] - brr[i]);
        }
        long val1 = 0;
        Arrays.sort(arr);
        Arrays.sort(brr);
        for (int i = 0; i < n; i++) {
            val1 += Math.abs(arr[i] - brr[i]);
        }
        return Math.min(val1 + k, val2);
    }
}