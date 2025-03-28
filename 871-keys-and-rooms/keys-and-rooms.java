class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        // adjList is already given to us.
        int[] vis = new int[n];
        dfs(0, rooms, vis);

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                flag = true;
                break;
            }
        }

        return !flag;
    }

    void dfs(int node, List<List<Integer>> rooms, int[] vis) {
        vis[node] = 1;
        for (int i = 0; i < rooms.get(node).size(); i++) {
            if (vis[rooms.get(node).get(i)] == 0) {
                dfs(rooms.get(node).get(i), rooms, vis);
            }
        }
    }
}