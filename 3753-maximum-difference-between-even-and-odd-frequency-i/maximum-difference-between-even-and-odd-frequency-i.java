class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddmax = -1;
        int evenmin = 1000;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > oddmax && freq[i] % 2 != 0) {
                oddmax = freq[i];
            }

            if (freq[i] != 0 && freq[i] < evenmin && freq[i] % 2 == 0) {
                evenmin = freq[i];
            } 
        }

        return oddmax - evenmin;
    }
}