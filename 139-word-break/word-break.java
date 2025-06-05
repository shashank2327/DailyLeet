class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(s, 0, wordSet, memo);
    }

    private boolean dfs(String s, int start, Set<String> wordSet, Map<Integer, Boolean> memo) {
        // base case;
        // traversed the whole string;
        if (start == s.length()) {
            return true;
        }

        if (memo.containsKey(start)) return memo.get(start);

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix) && dfs(s, end, wordSet, memo)) {
                memo.put(start, true);
                return true;
            }
        }

        memo.put(start, false);
        return false;
    }
}
