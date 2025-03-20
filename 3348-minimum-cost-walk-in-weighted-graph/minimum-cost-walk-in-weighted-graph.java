class Solution {

    void dfs(int node, int[] vis, int compNo, HashMap<Integer, Integer> nodeToCompMap, List<List<Integer>> adjList) {
        vis[node] = 1;
        nodeToCompMap.put(node, compNo);
        for (int i = 0; i < adjList.get(node).size(); i++) {
            int adjNode = adjList.get(node).get(i);
            if (vis[adjNode] == 0) {
                dfs(adjNode, vis, compNo, nodeToCompMap, adjList);
            }  
        }
    }


    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int m = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] vis = new int[n];
        HashMap<Integer, Integer> nodeToCompMap = new HashMap<>();
        HashMap<Integer, Integer> compToAndMap = new HashMap<>();


        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int compNo = 1;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, compNo, nodeToCompMap, adjList);
                compNo++;
            }
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            int currCompNo = nodeToCompMap.get(u);
            if (compToAndMap.containsKey(currCompNo)) {
                int currAnd = compToAndMap.get(currCompNo);
                compToAndMap.put(currCompNo, currAnd & wt);
            } else {
                compToAndMap.put(currCompNo, wt);
            }
        }

        int[] minCost = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int u = query[i][0];
            int v = query[i][1];
            int comp1 = nodeToCompMap.get(u);
            int comp2 = nodeToCompMap.get(v);

            if (comp1 != comp2) {
                minCost[i] = -1;
            } else {
                int currCompNo = nodeToCompMap.get(u);
                int andVal = compToAndMap.get(currCompNo);
                minCost[i] = andVal;
            }
        }

        return minCost;
    }
}