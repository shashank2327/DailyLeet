class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
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
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if (edges < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        for (int[] cable : connections) {
            int comp1 = cable[0];
            int comp2 = cable[1];

            if (ds.findUPar(comp1) == ds.findUPar(comp2)) {
                extra++;
            } else {
                ds.unionBySize(comp1, comp2);
            }
        }

        int disconnected = 0;

        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) disconnected++;
        }

        int req = disconnected - 1;

        if (extra >= req) {
            return req;
        } else {
            return -1;
        }
    }
}


// for -1 -> if number of comp is n, then minimum n - 1 edges should be there;