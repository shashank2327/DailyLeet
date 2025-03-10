class Solution {
    public long countOfSubstrings(String word, int k) {
        return atleast(word, k) - atleast(word, k + 1);
    }

    private long atleast(String s, int k) {
        long cnt = 0;
        int l = 0;
        int r = 0;
        int consonant = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            if (isVowel(s.charAt(r))) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            } else {
                consonant++;
            }

            while (map.size() == 5 && consonant >= k) {
                cnt += s.length() - r;
                if (isVowel(s.charAt(l))) {
                    int val = map.get(s.charAt(l)) - 1;
                    if (val == 0) {
                        map.remove(s.charAt(l));
                    } else {
                        map.put(s.charAt(l), val);
                    }
                } else {
                    consonant--;
                }
                l++;
            }

            r++;
        }

        return cnt;
    }
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}