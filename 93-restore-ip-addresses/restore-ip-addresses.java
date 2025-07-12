class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoringIps(s, "", 0, 0, result);
        return result;
    }

    public void restoringIps(String s, String path, int idx, int dots, List<String> result) {
        if (dots > 4) return;

        if (dots == 4 && idx >= s.length()) {
            result.add(path.substring(0, path.length() - 1));
            return;
        }

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            String num = s.substring(idx, idx + len);
            if (num.charAt(0) == '0' && len != 1) {
                break;
            } else if (Integer.parseInt(num) <= 255) {
                restoringIps(s, path + num  + ".", idx + len, dots + 1, result);
            }
        }
    }
}