class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        return fun(s1, s2);
    }

    private boolean fun(String s1, String s2) {
        int n = s1.length();
        if (s1.equals(s2)) return true;
        if (n == 1) return false;

        String key = s1 + " " + s2;

        if (map.containsKey(key)) return map.get(key);

        for (int i = 1; i < n; i++) {
            if 
            (
                fun(s1.substring(0, i), s2.substring(0, i)) && 
                fun(s1.substring(i) , s2.substring(i))
            ) {
                map.put(key, true);
                return true;
            } 

            if
            (
                fun(s1.substring(0, i), s2.substring(n - i)) &&
                fun(s1.substring(i), s2.substring(0, n - i))
            ) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }
}