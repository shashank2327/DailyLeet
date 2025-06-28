class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : word2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int cnt = 0;
        long result = 0;
        for (int right = 0; right < n; right++) {
            char ch = word1.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    cnt++;
                }
                while (cnt == m) {
                    result += n - right;
                    if (map.containsKey(word1.charAt(left))) {
                        map.put(word1.charAt(left), map.get(word1.charAt(left)) + 1);
                        if (map.get(word1.charAt(left)) > 0) {
                            cnt--;
                        }
                    }
                    left++;
                }
            }
        }

        return result;
    }
}