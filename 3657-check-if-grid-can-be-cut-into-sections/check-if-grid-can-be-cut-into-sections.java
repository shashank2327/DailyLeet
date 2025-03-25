class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        // The question is similar to merging interval;
        int m = rectangles.length;
        int[][] matx = new int[m][2];
        int[][] maty = new int[m][2];

        for (int i = 0; i < m; i++) {
            matx[i][0] = rectangles[i][0];
            matx[i][1] = rectangles[i][2];
            maty[i][0] = rectangles[i][1];
            maty[i][1] = rectangles[i][3];
        }        

        boolean verticalCut = check(matx);
        boolean horizontalCut = check(maty);

        return verticalCut || horizontalCut;
    }

    private boolean check(int[][] mat) {

        Arrays.sort(mat, Comparator.comparingInt(a -> a[0]));
        int n = mat.length;
        ArrayList<int[]> merged = new ArrayList<>();
        int[] prev = mat[0];

        for (int i = 1; i < n; i++) {
            int[] interval = mat[i];
            if (interval[0] < prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }

        merged.add(prev);

        return merged.size() > 2 ? true : false;
    }
}