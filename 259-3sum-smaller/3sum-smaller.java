class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int val = target - nums[i] - nums[j];

                int idx = binarySearch(nums, val);
                if (idx < j) continue;
                ans += idx - j;
            }
        }

        return ans;
    }

    private int binarySearch(int[] a, int val) {
        int n = a.length;
        int lo = 0;
        int hi = n - 1;


        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] >= val) {
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }

        return hi;
    }
}


/*
use two loops and get the third one via binary search;

 -2 + 0 + x < 2
 x < 4


*/