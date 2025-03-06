class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n= grid.length;
        int[] a = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[idx] = grid[i][j];
                idx++;
            }
        }
        return solve(a);
    }


    public int[] solve(int[] a) {
        long sum = 0;
        long squareSum = 0;
        long n = a.length;
        long actual = n * (n + 1) / 2;
        long actualSq = n * (n + 1) * (2* n + 1) / 6;
        for (int num: a) {
            sum += num;
            squareSum += (long)Math.pow(num, 2);
        }

        // a - b
        long ba = actual - sum;
        long bpa = (actualSq - squareSum) / ba;


        long b1 = (ba + bpa) / 2;
        long a1 = (bpa - ba) / 2;
        
        return new int[]{(int)a1, (int)b1};
    }
}