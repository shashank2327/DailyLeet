class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (char ch : word1.toCharArray()) {
            f1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            f2[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((f1[i] == 0 && f2[i] > 0) || (f1[i] > 0 && f2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(f1);
        Arrays.sort(f2);

        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }

        return true;
    }
}

/*
    a -> 2
    b -> 3
    c -> 1


    a -> 1
    b -> 2
    c -> 3
*/