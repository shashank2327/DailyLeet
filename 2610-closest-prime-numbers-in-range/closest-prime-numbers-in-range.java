class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] primes = new boolean[right + 1];
        sieve(primes, right);

        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (!primes[i]) {
                list.add(i);
            }
        }
        int l = -1;
        int r = -1;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff < min) {
                l = list.get(i - 1);
                r = list.get(i);
                min = diff;
            }
        }

        return new int[]{l, r};
    }

    private static void sieve(boolean[] primes, int n) {
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j <= n; j+=i) {
                    primes[j] = true;
                }
            }
        }
    }
}