class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c: word.toCharArray()) {
                counts.put(c, 0);
                adj.put(c, new ArrayList<>());
            }
        }


        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) return "";


            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    // updating the indegree;
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();

        for (Character c: counts.keySet()) {
            if (counts.get(c).equals(0)) {
                q.add(c);
            }
        }

        while (!q.isEmpty()) {
            Character c = q.poll();
            sb.append(c);
            for (Character nbr: adj.get(c)) {
                counts.put(nbr, counts.get(nbr) - 1);
                if (counts.get(nbr).equals(0)) {
                    q.add(nbr);
                }
            }
        }

        // presence of cycle;
        if (sb.length() < counts.size()) return "";

        return sb.toString();
    }
}