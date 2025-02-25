class Solution {
    
    public static final int MOD = (int)1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        int result = 0;
        int prefixSum = 0;
        int oddCount = 0;
        int evenCount = 1;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }

        return result;
    }
}