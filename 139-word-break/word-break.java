class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, Boolean> memo = new HashMap<>();
        return solve(s, 0, set, memo);
    }

    public boolean solve(String s, int idx, Set<String> set, Map<Integer, Boolean> memo) {
        if (idx == s.length()) {
            return true;
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (set.contains(sub) && solve(s, i + 1, set, memo)) {
                memo.put(idx, true);
                return true;
            }
        }

        memo.put(idx, false);
        return false;
    }
}