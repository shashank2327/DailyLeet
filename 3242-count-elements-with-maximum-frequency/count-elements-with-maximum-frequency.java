class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        int cnt = 0;
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > max) {
                cnt = 1;
                max = freq[num];
            } else if (freq[num] == max) {
                cnt++;
            }
        }

        return cnt * max;
    }
}