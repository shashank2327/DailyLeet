class Solution {

    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0); 
            String dst = ticket.get(1);
            if (!graph.containsKey(src)) {
                graph.put(src, new PriorityQueue<>());
            }
            graph.get(src).add(dst);
        }

        return graph;
    }

    private void dfs(
        List<String> res,
        Map<String, PriorityQueue<String>> graph,
        String src
    ) {

        //base case;
        //there is no dst from the given src
        if (graph.get(src) == null || graph.get(src).isEmpty()) {
            res.add(src);
            return;
        }

        while(!graph.get(src).isEmpty()) {
            String nxtDst = graph.get(src).poll();
            dfs(res, graph, nxtDst);
        }

        res.add(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        
        if (tickets == null || tickets.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);

        List<String> res = new ArrayList<>();
        dfs(res, graph, "JFK");

        Collections.reverse(res);
        return res;
    }
}