class Solution {

    private static final int MOD = (int)1e9 + 7;

    public int sumDecoded(long[] nums) {
        int n = nums.length;
        long res = 0;
        for (long val: nums) {
            long w = val % 10; // 2
            long d = val / 10; // 252
            int len = len(d); // 3

            long x = (long)(d / Math.pow(10, len - w)); // 25
            long y = (long)(d % (x * Math.pow(10, len - w))); // 
            
            long powCal = calculatePower(x, y, MOD);

            res = (res + powCal) % MOD;
        }

        return (int)(res % MOD);
    }

    private long calculatePower(long x, long y, long MOD) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            y = y / 2;
        }
        return result;
    }

    private int len(long val) {
        int cnt = 0;

        while (val != 0) {
            cnt++;
            val = val/10;
        }

        return cnt;
    }
}
/*
 2522

 w = 2;
 d = 252

 x = 25


*/