class Solution {
    private static final int MOD = (int)1e9 + 7;

    public static long binpow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < len; i++) {
            int minVal = nums[i];
            int maxVal = target - nums[i];
            
            int idx = binarySearch(nums, i, len - 1, maxVal);
            if (idx != -1 && idx >= i) {
                int numberOfElements = idx - i + 1;
                count = (count + binpow(2, numberOfElements - 1)) % MOD;
            }
        }
        return (int)(count);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int low = left;
        int high = right;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}

// brute force -> 1. Sort the array;
//using two loops try to search for a subarray whose min + max <= 9;
// T.C[brute force] -> O(n*n);

// optimal
// sort the array;
// for every number x, search for the floor of the number (target - x);
// use binary search.