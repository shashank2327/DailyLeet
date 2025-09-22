class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
        }

        Arrays.sort(freq);

        int val = freq[100];
        int cnt = 0;
        for (int i = 0; i <= 100; i++) {
            if (freq[i] == val) cnt++;
        }

        return cnt * val;
    }
}