class Solution {
    public int minimumLength(String s) {
        int[] map = new int[26];
        int n = s.length();
        int removed = 0;
        for (int i = 0; i < n; i++) {
            int ind = s.charAt(i) - 'a';
            map[ind]++;

            if (map[ind] == 3) {
                map[ind] -= 2;
                removed += 2;
            }
        }

        return n - removed;
    }
}