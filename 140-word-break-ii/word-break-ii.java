class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ls = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, String> memo = new HashMap<>();
        dfs(s, 0, set, "", ls, memo);

        // for (int i = 0; i < ls.size(); i++) {
        //     System.out.println(ls.get(i));
        // }

        return ls;
    }
    private void dfs(
        String s,
        int start,
        Set<String> wordSet,
        String temp,
        List<String> ls, 
        Map<Integer, String> memo
    ) {
        // base case: traversed the whole String;
        if (start == s.length()) {  
            String trimmed = temp.stripTrailing();
            ls.add(trimmed);
            return;
        }
        
        if (memo.containsKey(start) && memo.get(start) == temp) return;

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix)) {
                dfs(s, end, wordSet, temp + prefix + " ", ls, memo);
            }
        }

        memo.put(start, temp);
    }
}