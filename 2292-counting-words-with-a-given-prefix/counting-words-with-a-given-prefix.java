class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = words[i];
            if (s.startsWith(pref)) count++;
        }
        return count;
    }
}