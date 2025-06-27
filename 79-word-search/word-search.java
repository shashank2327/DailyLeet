class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, n, m, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean dfs(char[][] board, int r, int c, int n, int m, String word,
        int idx
    ) 
    {   
        if (idx == word.length()) {
            return true;
        }
        if (r >= n || c >= m || r < 0 || c < 0) {
            return false;
        }

        if (word.charAt(idx) != board[r][c] || board[r][c] == ' ') {
            return false;
        }

        char ch = board[r][c];
        board[r][c] = ' '; // marking it as visited;

        boolean up = dfs(board, r - 1, c, n, m, word, idx + 1);
        boolean down = dfs(board, r + 1, c, n, m, word, idx + 1);
        boolean left = dfs(board, r, c - 1, n, m, word, idx + 1);
        boolean right = dfs(board, r, c + 1, n, m, word, idx + 1);

        if (up || down || left || right) {
            return true;
        }

        board[r][c] = ch;
        return false;
    }
}