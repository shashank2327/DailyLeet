class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int x : arr) {
            freq[(x % k + k) % k]++;
        }
        if (freq[0] % 2 != 0) return false;
        for (int i = 1; i <= k / 2; ++i) {
            if (freq[i] != freq[k - i]) return false;
        }
        return true;
    }
}