class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            map.put(rowString, map.getOrDefault(rowString, 0) + 1);
        }

        int count = 0;

        for (int j = 0; j < n; j++) {
            int[] colArr = new int[n];
            for (int row = 0; row < n; row++) {
                colArr[row] = grid[row][j];
            }

            count += map.getOrDefault(Arrays.toString(colArr), 0);
        }

        return count;
    }
}