class Solution {

    private String validateIPv4(String s) {
        String[] nums = s.split("\\.", -1);

        for (String x: nums) {
            if (x.length() == 0 || x.length() > 3) return "Neither";

            if (x.charAt(0) == '0' && x.length() != 1) return "Neither";

            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch)) return "Neither";
            }

            if (Integer.parseInt(x) > 255) return "Neither";
        }


        return "IPv4";
    }

    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 4) return "Neither";
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }




    public String validIPAddress(String queryIP) {
        int n = queryIP.length();
        int dotCnt = 0;
        int colonCnt = 0;

        for (char ch: queryIP.toCharArray()) {
            if (ch == '.') {
                dotCnt++;
            } else if (ch == ':') {
                colonCnt++;
            }
        }

        if (dotCnt > 0 && colonCnt > 0) {
            return "Neither";
        } else if (dotCnt == 3) {
            return validateIPv4(queryIP);
        } else if (colonCnt == 7) {
            return validateIPv6(queryIP);
        } else {
            return "Neither";
        }
    }
}