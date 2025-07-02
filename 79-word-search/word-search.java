class Solution {

    int[] dx = {0, 0, 1, -1};  // for horizontal movement;
    int[] dy = {1, -1, 0, 0}; // for vertical movement;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, 0, i, j, n, m)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int idx, int row, int col, int n, int m) {
        if (idx == word.length()) {
            return true;
        } 
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return false;
        }
        if (word.charAt(idx) != board[row][col]) return false;
        
        char ch = board[row][col];
        board[row][col] = '#';  // marked as visited;

        for (int i = 0; i < 4; i++) {
            int nr = dx[i] + row;
            int nc = dy[i] + col;

            if (dfs(board, word, idx + 1, nr, nc, n, m)) {
                return true;
            }
        }

        board[row][col] = ch;

        return false;
    }
}