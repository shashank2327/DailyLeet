class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        char[] numChar = num.toCharArray();
        String res = "";
        int val = -1;
        for (int i = 2; i < n; i++) {
            if (numChar[i] == numChar[i - 1] && numChar[i - 1] == numChar[i - 2]) {
                if (numChar[i] - '0' > val) {
                    res = num.substring(i - 2, i + 1);
                    val = numChar[i] - '0';
                }
            }
        }

        return res;
    }
}