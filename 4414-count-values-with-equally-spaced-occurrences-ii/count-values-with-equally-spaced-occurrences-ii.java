class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;

        int[][] mat = new int[n][2];
        for (int i = 0; i < n; i++) {
            mat[i][0] = nums[i];
            mat[i][1] = i;
        }

        Arrays.sort(mat, (a, b) -> Integer.compare(a[0], b[0]));


        int i = 1; 
        int cnt = 1;
        int ans = 0;
        int maxDiff = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;

        while (i < n) {
            if (mat[i][0] == mat[i - 1][0]) {
                maxDiff = Math.max(maxDiff, mat[i][1] - mat[i - 1][1]);
                minDiff = Math.min(minDiff, mat[i][1] - mat[i - 1][1]);
                cnt++;
            } else {
                if (cnt >= 3 && minDiff == maxDiff) ans++;
                cnt = 1;
                maxDiff = Integer.MIN_VALUE;
                minDiff = Integer.MAX_VALUE;
            }
            i++;
        }

        if (cnt >= 3 && minDiff == maxDiff) ans++;

        return ans;
    }
}