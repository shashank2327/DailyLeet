class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        char prev = s.charAt(0);
        int freq = 1;
        builder.append(s.charAt(0));
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == prev) {
                freq++;
            } else {
                prev = s.charAt(i);
                freq = 1;
            }

            if ( freq < 3) {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}