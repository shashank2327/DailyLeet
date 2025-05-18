
class Solution {

    int solve(char[][] mat, List<int[]>[] pos) {
        int n = mat.length, m = mat[0].length;
        if (mat[0][0] == '#' || mat[n-1][m-1] == '#')
            return -1;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        boolean[] used = new boolean[26];
        Deque<int[]> q = new ArrayDeque<>();
        dist[0][0] = 0;
        q.addFirst(new int[]{0, 0});

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];
            int d = dist[x][y];
            if (x == n-1 && y == m-1) 
                return d;

            char c = mat[x][y];
            if (c >= 'A' && c <= 'Z') {
                int idx = c - 'A';
                if (!used[idx]) {
                    used[idx] = true;
                    for (int[] p : pos[idx]) {
                        int px = p[0], py = p[1];
                        if (d < dist[px][py]) {
                            dist[px][py] = d;
                            q.addFirst(new int[]{px, py});
                        }
                    }
                }
            }

            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX< n && newY >= 0 && newY < m
                    && mat[newX][newY] != '#' && d + 1 < dist[newX][newY]) {
                    dist[newX][newY] = d + 1;
                    q.addLast(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }
    
    public int minMoves(String[] matrix) {
        int n = matrix.length, m = matrix[0].length();
    
        List<int[]>[] pos = new List[26];
        char[][] mat = new char[n][m];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mat[i]= matrix[i].toCharArray();
            for (int j = 0; j < m; j++) {
                char c = mat[i][j];
                if (c >= 'A' && c <= 'Z') {
                    pos[c - 'A'].add(new int[]{i, j});
                }
            }
        }
        return solve(mat, pos);
    }

    
}