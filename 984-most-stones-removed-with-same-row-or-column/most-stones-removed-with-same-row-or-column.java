public class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();


    // Constructor (Taking number of nodes);
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }


    // Path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }


    // Finding union using rank;
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }


    // Finding union using size;
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

/* ------------------------------------------------------------------------------------- */


class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    edges.add(new int[] {i, j});
                }
            }
        }

        int m = edges.size();

        DisjointSet ds = new DisjointSet(n - 1);

        for (int i = 0; i < m; i++) {
            int[] edge = edges.get(i);
            int u = edge[0];
            int v = edge[1];
            if (ds.findUPar(u) != ds.findUPar(v)) {
                ds.unionBySize(u, v);
            }
        }


        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ds.parent.set(i, ds.findUPar(i));
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(ds.parent.get(i))){
                set.add(ds.parent.get(i));
            } else {
                ans++;
            }
        }


        return ans;
    }
}