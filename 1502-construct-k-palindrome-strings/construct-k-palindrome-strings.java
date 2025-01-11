class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        // construct k palindromes using all the characters present in s
        // k = 2
        // odd frequnency charcaters could be atmost 2.
        // for certain k maximum odd frequency characters can be k.

        if (n < k) return false;

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int oddFreqCount = 0;
        for (int num : freq) {
            if (num % 2 != 0) oddFreqCount++;
        }
        if (oddFreqCount <= k) {
            return true;
        } else {
            return false;
        }
    }
}