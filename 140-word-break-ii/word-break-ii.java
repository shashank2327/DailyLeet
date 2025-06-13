class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> ls = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        dfs(s, 0, set, new ArrayList<>(), ls);

        // for (int i = 0; i < ls.size(); i++) {
        //     System.out.println(ls.get(i));
        // }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            String subStr= "";
            for (int j = 0; j < ls.get(i).size(); j++) {
                if (j != ls.get(i).size() - 1) {
                    subStr += ls.get(i).get(j) + " ";
                } else {
                    subStr += ls.get(i).get(j);
                }
                
            }
            res.add(subStr);
        }

        return res;
    }
    private void dfs(
        String s,
        int start,
        Set<String> wordSet,
        List<String> temp,
        List<List<String>> ls
    ) {
        // base case: traversed the whole String;
        if (start == s.length()) {  
            ls.add(new ArrayList<>(temp));//adding the copy of temp list we made so far
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix)) {
                temp.add(prefix);
                dfs(s, end, wordSet, temp, ls);
                temp.remove(temp.size() - 1);
            }
        }
    }
}