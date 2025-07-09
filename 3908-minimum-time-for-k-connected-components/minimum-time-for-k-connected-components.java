class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(i);
        }
    } 

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
class Solution {
    public int minTime(int n, int[][] edges, int k) {
        int m = edges.length;
        int lo = 0;
        int hi = 0;
        for (int[] edge : edges) {
            hi = Math.max(hi, edge[2]);
        }
        int result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            DisjointSet ds = new DisjointSet(n);
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int time = edge[2];

                // means the edge can not be removed;
                if (time > mid) {
                    ds.unionBySize(u, v);
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(ds.findUPar(i));
            }

            if (set.size() >= k) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }


        return result;
    }
}
