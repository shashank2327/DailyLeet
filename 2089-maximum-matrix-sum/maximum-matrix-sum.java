class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negativeCount = 0;
        int min = Integer.MAX_VALUE;

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < 0) negativeCount++;
                int val = Math.abs(matrix[i][j]);
                min = Math.min(min, val);
                sum += val;
            }
        }

        if (negativeCount % 2 == 0) {
            return sum;
        }

        System.out.println(sum);

        return sum - (2 * min);
    }
}