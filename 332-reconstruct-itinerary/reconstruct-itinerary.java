class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        // edge_case1 -> If there are no tickets;
        if (tickets == null || tickets.isEmpty()) {
            return Collections.EMPTY_LIST;
        }


        // building my graph;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);

            graph.putIfAbsent(src, new PriorityQueue<>());
            graph.get(src).add(dst);
        }

        List<String> result = new ArrayList<>();
        dfs(graph, "JFK", result);

        Collections.reverse(result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String src, List<String> result) {
        
        if (graph.get(src) == null || graph.get(src).isEmpty()) {
            result.add(src);
            return;
        }
        while (!graph.get(src).isEmpty()) {
            String dst = graph.get(src).poll();
            dfs(graph, dst, result);
        }

        result.add(src);
    }
}