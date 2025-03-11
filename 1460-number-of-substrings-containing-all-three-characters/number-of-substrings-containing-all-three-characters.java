class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int cnt = 0;

        while (r < n) {

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            if (map.size() == 3) {
                while (map.size() == 3) {
                    cnt += n - r;
                    int val = map.get(s.charAt(l)) - 1;
                    if (val == 0) {
                        map.remove(s.charAt(l));
                    } else {
                        map.put(s.charAt(l), val);
                    }
                    l++;
                }
            }
            r++;
        }


        return cnt;
    }
}