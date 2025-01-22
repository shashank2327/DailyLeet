class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left + 1 < n && arr[left] <= arr[left + 1]) left++;
        while (right - 1 >= 0 && arr[right - 1] <= arr[right]) right--;

        if (left >= right) return 0;

        int ans = right, l = 0, r = right;

        while (l <= left) {
            while (r < n && arr[r] < arr[l]) r++;
            ans = Math.min(ans, r-l-1);
            l++;
        }

        return ans;
    }
    // 1,2,3,4,10,5, 6, 3, 4, 5,8,3, 2,1
}