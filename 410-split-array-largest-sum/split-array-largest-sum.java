class Solution {
    public int splitArray(int[] nums, int k) {
        int ans = binarySearch(nums, k);
        return ans;
    }

    private int binarySearch(int[] arr, int k) {
        int n = arr.length;
        int low = -1;
        for (int num : arr) {
            low = Math.max(low, num);
        }
        int high = Arrays.stream(arr).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int partitionsPossible = count(arr, mid, n);
            if (partitionsPossible > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int count(int[] arr, int sum, int n) {
        int ct = 1;
        long val = 0;
        for (int i = 0; i < n; i++) {
            if (val + arr[i] <= sum) {
                val += arr[i];
            } else {
                ct++;
                val = arr[i];
            }
        }
        return ct;
    }
}