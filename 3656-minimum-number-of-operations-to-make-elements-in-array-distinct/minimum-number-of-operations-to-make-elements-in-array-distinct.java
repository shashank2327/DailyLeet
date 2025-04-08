class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;

        boolean[] isDistinct = new boolean[n];
        isDistinct[n - 1] = true;

        int[] freq = new int[101];
        freq[nums[n - 1]]++;


        for (int i = n - 2; i >= 0; i--) {
            if (freq[nums[i]] == 0 && isDistinct[i + 1] == true) {
                isDistinct[i] = true;
                freq[nums[i]]++;
            } else {
                break;
            }
        }

        int idx = 0;
        int ans = 0;
        while (idx < n) {
            if (isDistinct[idx]) {
                return ans;
            } else {
                ans++;
                idx += 3;
            }
        }

        return ans;
    }
}