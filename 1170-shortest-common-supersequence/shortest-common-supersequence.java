class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return longestCommonSubsequence(str1, str2);
    }


    public String longestCommonSubsequence(String text1, String text2) {
        
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int len = dp[n1][n2];
        int i = n1;
        int j = n2;

        int index = len - 1;
        String ans = "";

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans += text1.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += text1.charAt(i - 1);
                i--;
            } else {
                ans += text2.charAt(j - 1);
                j--;
            }
        }


        while (i > 0) {
            ans += text1.charAt(i - 1);
            i--;
        }

        while (j > 0) {
            ans += text2.charAt(j - 1);
            j--;
        }

        String ans2=new StringBuilder(ans).reverse().toString();
        return ans2;
    }
}