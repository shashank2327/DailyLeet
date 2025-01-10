class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        Map<Character, Integer> count2 = new HashMap<>();

        for (String w : words2) {
            Map<Character, Integer> countW = getCountMap(w);
            for (Map.Entry<Character, Integer> entry : countW.entrySet()) {
                char c = entry.getKey();
                int cnt = entry.getValue();
                count2.put(c, Math.max(count2.getOrDefault(c, 0), cnt));
            }
        }

        List<String> res = new ArrayList<>();
        for (String w : words1) {
            Map<Character, Integer> countW = getCountMap(w);
            boolean isUniversal = true;
            for (Map.Entry<Character, Integer> entry : count2.entrySet()) {
                char c = entry.getKey();
                int cnt = entry.getValue();
                if (countW.getOrDefault(c, 0) < cnt) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                res.add(w);
            }
        }

        return res;
    }

    private Map<Character, Integer> getCountMap(String word) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        return countMap;
    }
}