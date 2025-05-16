class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        
        int n = words.length;
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        for (int i = 0; i < n; i++) hash[i] = i;
        int hashIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (check(words[i], words[j]) && groups[i] != groups[j] && dp[i] < dp[j] + 1) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;        
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                hashIndex = i;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            result.add(words[hashIndex]);
            hashIndex = hash[hashIndex];
        }

        Collections.reverse(result);
        return result;
    }

    private boolean check (String s, String t) {
        if (s.length() != t.length()) return false;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
                if (cnt > 1) return false;
            }    
        }

        return cnt == 1 ? true : false;
    }
}