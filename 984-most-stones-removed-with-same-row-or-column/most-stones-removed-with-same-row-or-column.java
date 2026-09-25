class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUPar(int n) {
        if (parent.get(n) == n) {
            return n;
        }

        int ulp = findUPar(parent.get(n));
        parent.set(n, ulp);
        return ulp;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    edges.add(new int[]{i, j});
                }
            }
        }

        DisjointSet ds = new DisjointSet(n);

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if (ds.findUPar(u) != ds.findUPar(v)) {
                ds.unionBySize(u, v);
            }
        }

        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(ds.findUPar(i))) {
                ans++;
            } else {
                set.add((ds.findUPar(i)));
            }
        }

        return ans;
    }
}