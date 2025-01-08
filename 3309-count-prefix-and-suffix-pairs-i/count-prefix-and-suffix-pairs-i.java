class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int len = words.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (words[j].length() >= words[i].length()) {
                    int n = words[i].length();
                    int m = words[j].length();
                    if (words[j].substring(0, n).equals(words[i]) && 
                            words[j].substring(m - n, m).equals(words[i])) {
                                count++;
                            }
                }
            }
        }

        return count;
    }
}