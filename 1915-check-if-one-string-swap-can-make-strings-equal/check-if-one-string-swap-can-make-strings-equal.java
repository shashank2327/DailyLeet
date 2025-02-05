class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) return false;
        int[] arr = new int[26];
        int count = 0;
        for (int i = 0; i < n1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) return false;
                arr[s1.charAt(i) - 'a']++;
                arr[s2.charAt(i) - 'a']--;
            }
        }

        for (int num : arr) {
            if (num != 0) return false;
        }

        return true;
    }
}