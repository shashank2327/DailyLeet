class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        seen.add(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String currWord = q.poll();
                if (currWord.equals(endWord)) {
                    return level;
                }
                for (String word : wordList) {
                    if (singleCharDifference(currWord, word) && !seen.contains(word)) {
                        seen.add(word);
                        q.offer(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public boolean singleCharDifference(String s1, String s2) {
        int cnt = 0;
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}