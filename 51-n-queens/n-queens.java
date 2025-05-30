class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] a = new char[n][n];
        for (char[] x : a) Arrays.fill(x, '.');

        fun(ans, a, 0);
        return ans;
    }

    private void fun(List<List<String>> ans, char[][] arr, int row) {
        if (row == arr.length) {
            ans.add(build(arr));
            return;
        }

        for (int col = 0; col < arr.length; col++) {
            if (isValid(arr, row, col)) {
                arr[row][col] = 'Q';
                fun(ans, arr, row + 1);
                arr[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] arr, int row, int col) {
        for (int i = 0; i  < row; i++) {
            if (arr[i][col] == 'Q') return false;
        }

        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (arr[r][c] == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        while (r >= 0 && c != arr.length) {
            if (arr[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        return true;

    }

    private List<String> build(char[][] arr) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            board.add(new String(arr[i]));
        }

        return board;
    }
}