class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
         Set<String> supp = new HashSet<>();
         Map<String, Integer> recipeToInd = new HashMap<>();
         Map<String, List<String>> graph = new HashMap<>();

         for (String supply : supplies) {
            supp.add(supply);
         }

         for (int i = 0; i < recipes.length; i++) {
            recipeToInd.put(recipes[i], i);
         }

         int[] indegree = new int[recipes.length];

         for (int i = 0; i < recipes.length; i++) {

            for (String ingredient : ingredients.get(i)) {
                if (!supp.contains(ingredient)) {
                    graph.putIfAbsent(ingredient, new ArrayList<String>());
                    graph.get(ingredient).add(recipes[i]);
                    indegree[i]++;
                }
            }
         }

         Queue<Integer> q = new LinkedList<>();
         for (int i = 0; i < recipes.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
         }

         List<String> ans = new LinkedList<>();

         while (!q.isEmpty()) {
            int idx = q.poll();
            String recipe = recipes[idx];
            ans.add(recipe);

            if (!graph.containsKey(recipe)) continue;
            
            for (String dependent : graph.get(recipe)) {
                if (--indegree[recipeToInd.get(dependent)] == 0) {
                    q.add(recipeToInd.get(dependent));
                }
            }
         }

         return ans;
    }
}