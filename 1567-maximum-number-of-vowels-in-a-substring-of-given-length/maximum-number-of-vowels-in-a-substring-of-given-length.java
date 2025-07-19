class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }

        int max = vowelCount;

        int left = 0;
        int right = k;
        
        while (right < n) {
            if (isVowel(s.charAt(left))) {
                vowelCount--;
            }
            if (isVowel(s.charAt(right))) {
                vowelCount++;
            }
            max = Math.max(max, vowelCount);
            left++;
            right++;
        }
        return max;
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}