class Solution {

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long countSmaller(long mid, int[] coins) {
        long count = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = lcm / gcd(lcm, coins[i]) * coins[i];
                }
            }

            // Inclusion - Exclusion principle;
            if (bits % 2 == 1) {
                count += mid/lcm;
            } else {
                count -= mid/lcm;
            }
        }

        return count;
    }

    public long findKthSmallest(int[] coins, int k) {
        
        int maxCoin = 0;

        for (int coin: coins) {
            maxCoin = Math.max(maxCoin, coin);
        }

        long left = 1;
        long right = (long) maxCoin * k;

        long ans = -1;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (countSmaller(mid, coins) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
