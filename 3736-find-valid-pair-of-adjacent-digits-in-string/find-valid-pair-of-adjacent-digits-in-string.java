class Solution {
    public String findValidPair(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int i = 0;
        while (i < n - 1) {
            int fdig = s.charAt(i) - '0';
            int sdig = s.charAt(i + 1) - '0';
            if (fdig != sdig && map.get(s.charAt(i)) == fdig && map.get(s.charAt(i + 1)) == sdig) {
                return s.substring(i, i + 2);
            }
            i++;
        }

        return "";
    }
}