class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        //DFS
        for (int j = 0; j < col; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, j, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic);
        }

        // Getting the common cells;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    // defth_first_search function;
    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean) {
        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length) return;
        if (matrix[i][j] < prev || ocean[i][j]) return;
        ocean[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dfs(matrix, i + dx[k], j + dy[k], matrix[i][j], ocean);
        }
    }
}