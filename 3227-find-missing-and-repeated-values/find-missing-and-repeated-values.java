class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n= grid.length;
        int[] a = new int[(n * n) + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[grid[i][j]]++;
            }
        }
        int a1 = -1;
        int b = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 2) {
                a1 = i;
            }
            if (a[i] == 0) {
                b = i;
            }
        }

        return new int[]{a1, b};
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