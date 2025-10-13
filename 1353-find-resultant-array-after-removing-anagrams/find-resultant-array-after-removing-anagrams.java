class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        boolean[] deleted = new boolean[n];
        List<String> result = new ArrayList<>(); 
        int i = n - 1;
        while (i > 0) {
            if (checkAnagram(words[i], words[i - 1])) {
                deleted[i] = true;
            }
            i--;
        }
        for (int k = 0; k < n; k++) {
            if (!deleted[k]) {
                result.add(words[k]);
            }
        }
        return result;
    }

    public boolean checkAnagram(String word1, String word2) {
        int[] freq = new int[26];

        for (char ch : word1.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq[ch - 'a']--;
        }

        for (int num : freq) {
            if (num != 0) return false;
        }

        return true;
    }
}