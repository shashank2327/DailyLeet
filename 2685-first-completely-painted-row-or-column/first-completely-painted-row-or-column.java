class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int ind = -1;
        int m = mat.length;
        int n = mat[0].length;
        int[] cols = new int[n];
        int[] rows = new int[m];
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                map.put(val, new int[]{i, j});
            }
        }

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int[] rc = map.get(arr[i]);
            rows[rc[0]]++;
            cols[rc[1]]++;
            if (rows[rc[0]] == n || cols[rc[1]] == m) {
                ind = i;
                break;
            }
        }
        return ind;
    }
}