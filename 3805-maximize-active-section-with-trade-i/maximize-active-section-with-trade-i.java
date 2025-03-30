class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') oneCount++;
        }

        int max = 0;
        int prev = 0;
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                curr++;
            } else if (prev == 0) {
                prev = curr;
                curr = 0;
            } else if (prev > 0 && curr > 0) {
                max = Math.max(max, prev + curr);
                prev = curr;
                curr = 0;
            }
        }

        if (prev > 0 && curr > 0) {
            max = Math.max(max, prev + curr);
        }

        return oneCount + max;
    }
}