class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int lo = 0;
        int hi = m - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int maxRowIndex = findMaxIndex(mat, n, m, mid);

            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;

            if (mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right) {
                return new int[]{maxRowIndex, mid};
            } else if (mat[maxRowIndex][mid] < left) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return new int[] {-1, -1};
    }

    public int findMaxIndex(int[][] mat, int n, int m, int mid) {
        int maxValue = -1;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][mid] > maxValue) {
                maxValue = mat[i][mid];
                idx = i;
            }
        }
        return idx;
    }
}