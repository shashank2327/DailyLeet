class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(Integer.toString(cnt) + s.charAt(i - 1) + "");
                cnt = 1;
            } else {
                cnt++;
            }
        }

        sb.append(Integer.toString(cnt) + s.charAt(s.length() - 1) + "");

        return sb.toString();
    }
}