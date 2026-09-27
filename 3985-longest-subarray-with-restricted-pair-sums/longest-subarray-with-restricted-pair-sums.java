class Solution {
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[501];

        int left = 0;
        int max = 0;

        for (int right = 0; right < n; right++) {
            int x = nums[right];

            while (!canAdd(x, freq)) {
                freq[nums[left]]--;
                left++;
            }

            freq[x]++;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    private boolean canAdd(int x, int[] freq) {
        for (int a = 1; a <= 500; a++) {
            if (freq[a] == 0) continue; // that value does not exit in the window;

            int b = x - a;

            if (b < 1 || b > 500 || freq[b] == 0) continue;

            if (a != b || freq[a] >= 2) return false;
        }

        for (int a = 1; a <= 500; a++) {
            if (freq[a] == 0) continue;

            int b = a + x;

            if (b <= 500 && freq[b] > 0) return false;
        }

        return true;
    }
}