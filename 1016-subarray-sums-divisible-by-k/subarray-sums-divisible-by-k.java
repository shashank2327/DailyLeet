// Number of subarray whose sum is divisble by k;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int pMod = 0;
        int ans = 0;

        int[] mod = new int[k];
        mod[0] = 1;

        for (int num : nums) {
            pMod = (pMod + (num % k) + k) % k; // ((num % k) + k) % k -> removes negative remainders;
            ans += mod[pMod];
            mod[pMod]++;
        }


        return ans;
    }
}