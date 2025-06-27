class Solution {
    public int totalNQueens(int n) {
        
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        int result = queenPlacementsWays(board, 0);
        return result;
    }

    private int queenPlacementsWays(char[][] board, int row) {
        if (row == board.length) {
            return 1;
        }

        int ans = 0;

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                ans += queenPlacementsWays(board, row + 1);
                board[row][col] = '.';
            }
        }

        return ans;
    }

    private boolean isValid(char[][] board, int row, int col) {
        // traverse all the column for that row;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;

        while (r >= 0 && c < board.length) {
            if (board[r][c] == 'Q') {
                return false;
            }

            r--;
            c++;
        }

        return true;
    }
}