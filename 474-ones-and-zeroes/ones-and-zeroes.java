class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int zcnt = 0;
            int ocnt = 0;
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') {
                    zcnt++;
                } else {
                    ocnt++;
                }
            }
            map.put(i, new int[]{zcnt, ocnt});
        }

        int[][][] memo = new int[len][m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        return fun(m, n, 0, 0, 0, map, len, memo);
    }

    private int fun(
        int m, 
        int n, 
        int z, 
        int o, 
        int i, 
        Map<Integer, int[]> map, 
        int len,
        int[][][] memo
    ) 
    {
        if (i >= len) {
            return 0;
        }

        if (memo[i][z][o] != -1) {
            return memo[i][z][o];
        }

        int take = 0;
        if (z + map.get(i)[0] <= m && o + map.get(i)[1] <= n) {
            take = 1 + fun(m, n, z + map.get(i)[0], o + map.get(i)[1], i + 1, map, len, memo);
        }

        int notTake = fun(m, n, z, o, i + 1, map, len, memo);


        return memo[i][z][o] = Math.max(take, notTake);
    }
}