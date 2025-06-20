class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < n) {
            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), 1);
                max = Math.max(r - l + 1, max);
                r++;
            } else {
                while (map.containsKey(s.charAt(r))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    if (map.get(s.charAt(l)) == 0) {
                        map.remove(s.charAt(l));
                    }
                    l++;
                }
            }
        }
        max = Math.max(max, r - l);
        return max;
    }
}