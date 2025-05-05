class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        findPath(0, graph, paths, new ArrayList<>());
        return paths;
    }


    private void findPath(
        int node, 
        int[][] graph, 
        List<List<Integer>> ans, 
        List<Integer> curr
    ) {

        curr.add(node);

        // If the node I am one is the destination node;
        // Add the path to the answer\t List;
        // Then backtrack.
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }

        // If we didn't reach the destination then explore;

        for (int i : graph[node]) {
            findPath(i, graph, ans, curr);
        }

        curr.remove(curr.size() - 1);
    }
}