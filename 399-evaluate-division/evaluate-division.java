class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];


        // DOING DFS FOR EACH QUERY;
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!gr.containsKey(u) || !gr.containsKey(v)) {
                finalAns[i] = -1.0;
            } else {
                HashSet<String> vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(u, v, gr, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }


    // BUILDING THE GRAPH
    public HashMap<String, HashMap<String, Double>> buildGraph(
        List<List<String>> equations, 
        double[] values
    ) {
        
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            gr.putIfAbsent(u, new HashMap<>());
            gr.putIfAbsent(v, new HashMap<>());

            gr.get(u).put(v, value);
            gr.get(v).put(u, 1.0 / value);
        }

        return gr;
    }


    // DFS TRAVERSAL
    public void dfs (
        String node,
        String dest,
        HashMap<String, HashMap<String, Double>> gr,
        HashSet<String> vis,
        double[] ans, 
        double temp
    ) {
        if (vis.contains(node)) return;

        vis.add(node);
        if (node.equals(dest)) {
            ans[0] = temp;
            return;
        }


        for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
            String ne = entry.getKey();
            Double val = entry.getValue();
            dfs(ne, dest, gr, vis, ans, val * temp);
        }
    }
}