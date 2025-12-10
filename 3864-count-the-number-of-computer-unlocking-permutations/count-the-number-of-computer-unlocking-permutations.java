class Solution {
    private static int MOD = (int)(1e9 + 7);

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        boolean check = false;
        int min = complexity[0];
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= min) {
                check = true;
                break;
            }
        }

        if (check) {
            return 0;
        }

        int remain = n - 1;
        int factorial = fac(remain);

        return factorial;
    }

    private int fac(int n) {
        long fac = 1;
        for (long i = 2; i <= n; i++) {
            fac = (fac * i) % MOD;
        }
        return (int)fac;
    }
}