class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> l = new HashMap<>();
        Map<Integer, Integer> r = new HashMap<>();
        long max = -1;

        for (int num : nums) {
            r.put(num, r.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
        }
        long cnt = 0;
        for (int j = 0; j < n; j++) {
            int m = nums[j];
            r.put(m, r.get(m) - 1);

            int lCnt = l.getOrDefault(m * 2, 0);
            int rCnt =  r.getOrDefault(m * 2, 0);

            cnt = (cnt + (long) lCnt * rCnt) % MOD;

            l.put(m, l.getOrDefault(m, 0) + 1);
        }

        return (int) cnt;
    }
}