class Solution {
    public int countSymmetricIntegers(int low, int high) {
        
        int cnt = 0;

        for (int i = low; i <= high; i++) {
            String nums = Integer.toString(i);
            if (nums.length() % 2 != 0) {
                continue;
            }
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < nums.length()/2; j++) {
                sum1 += nums.charAt(j) - '0';
                sum2 += nums.charAt(nums.length() - j - 1) - '0';
            }

            if (sum1 == sum2) cnt++;
        }

        return cnt;
    }
}