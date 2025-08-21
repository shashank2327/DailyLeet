class Solution {
    public int numSubmat(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;

        int count = 0;

        int[] height = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }

                int minHeight = height[j];

                for (int k = j; k >= 0; k--) {
                    if (mat[i][k] == 0) {
                        break;
                    }

                    minHeight = Math.min(minHeight, height[k]);
                    count += minHeight;
                }
            }
        }

        return count;
    }
}