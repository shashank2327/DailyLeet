class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int l = 0;
        int minL = 0;
        int len = s.length() + 1;
        int cnt  = 0;

        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                if (map.get(s.charAt(r)) >= 0) {
                    cnt++;
                }
                while (cnt == t.length()) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        minL = l;
                    }
                    if (map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                        if (map.get(s.charAt(l)) > 0) {
                            cnt--;
                        }
                    }
                    l++;
                }
            }
        }

        if (len > s.length()) return "";

        return s.substring(minL, minL + len);
    }
}