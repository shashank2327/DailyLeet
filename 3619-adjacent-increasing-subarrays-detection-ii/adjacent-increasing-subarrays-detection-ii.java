class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int lo = 0;
        int hi = n - 1;

        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean flag =  hasIncreasingSubarrays(nums, mid);
            if (flag) {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return result;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int cnt = 1;
        int preCnt = 0;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cnt++;
            } else {
                preCnt = cnt;
                cnt = 1;
            }

            ans = Math.max(ans, Math.min(preCnt, cnt));
            ans = Math.max(ans, cnt/2);
        }

        return ans >= k;
    }

    // private boolean check(List<Integer> nums, int idx, int k) {
    
    //     for (int i = idx + 1; i < idx + k; i++) {
    //         if (nums.get(i) <= nums.get(i - 1)) return false;
    //     }
    //     return true;
    // }
}