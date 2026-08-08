class WordDistance {

    Map<String, List<Integer>> positions;

    public WordDistance(String[] words) {
        this.positions = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            List<Integer> pos = this.positions.getOrDefault(words[i], new ArrayList<>());
            pos.add(i);
            this.positions.put(words[i], pos);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> loc1;
        List<Integer> loc2;

        loc1 = this.positions.get(word1);
        loc2 = this.positions.get(word2);

        int l1 = 0;
        int l2 = 0;

        int min = Integer.MAX_VALUE;

        while (l1 < loc1.size() && l2 < loc2.size()) {
            min = Math.min(min, Math.abs(loc1.get(l1) - loc2.get(l2)));

            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }            
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */