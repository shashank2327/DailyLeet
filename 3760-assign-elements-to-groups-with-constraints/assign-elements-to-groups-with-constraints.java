class Solution {
    public int[] assignElements(int[] g, int[] e) {
        int n = g.length;
        int m = e.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) map.put(e[i], map.getOrDefault(e[i], i));

        for (int i = 0; i < n; i++) {
            ans[i] = fun(g[i], map);
        }
        return ans;
    }

    private int fun(int num, HashMap<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        // all the factors of num
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                list.add(num / i);
            }
        }

        int ind = 0;
        int min = Integer.MAX_VALUE;
        while (ind < list.size()) {
            int factor = list.get(ind);
            // If my map contains that factor
            if (map.containsKey(factor)) {
                min = Math.min(min, map.get(factor));
            }
            ind++;
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }
}