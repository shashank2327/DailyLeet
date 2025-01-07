import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && words[j].length() >= words[i].length() && strStr(words[j], words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }

    public boolean strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return true;
        }

            // Compute the LPS array
        int[] lps = new int[needle.length()];
        int prevLPS = 0, i = 1;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else {
                if (prevLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLPS = lps[prevLPS - 1];
                }
            }
        }

            // Search for the needle in the haystack
        int j = 0; // Pointer for needle
        i = 0; // Pointer for haystack
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == needle.length()) {
                return true;
            }
        }
        return false;
    }
}
