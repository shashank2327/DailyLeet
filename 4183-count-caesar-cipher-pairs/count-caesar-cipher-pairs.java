class Solution {
    public long countPairs(String[] words) {
        
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            String normWord = normalize(words[i]);
            int cnt = map.getOrDefault(normWord, 0);
            map.put(normWord, cnt + 1);
            ans += cnt;
        }
        

        return ans;
    }

    public String normalize(String s) {
        if(s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int c = s.charAt(0) - 'a';
        for(int i = 0; i < s.length(); ++i) {
            int v = s.charAt(i) - 'a';
            int n = (v - c + 26) % 26;
            sb.append((char)('a' + n));
        }
        return sb.toString();
    }
}

/*
    a

*/