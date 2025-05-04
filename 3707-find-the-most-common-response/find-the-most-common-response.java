class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        int n = responses.size();
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            Set<String> set = new HashSet<>();
            for (String s : responses.get(i)) {
                set.add(s);
            }

            for (String s : set) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int maxFreq = 0;
        String ans = "";

        for (Map.Entry<String, Integer> i : map.entrySet()) {
            if (i.getValue() > maxFreq) {
                maxFreq = i.getValue();
                ans = i.getKey();
            }
        }

        return ans;
    }
}