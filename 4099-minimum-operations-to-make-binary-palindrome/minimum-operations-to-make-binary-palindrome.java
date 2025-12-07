class Solution {
    public int[] minOperations(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            int count1 = 0;
            while (!isPalindrome(convertToBinary(num))) {
                count1++;
                num++;
            }

            int count2 = 0;
            num = nums[i];

            while (!isPalindrome(convertToBinary(num))) {
                num--;
                count2++;
            }

            result[i] = Math.min(count1, count2);
        }

        return result;
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    public String convertToBinary(int num) {
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int q = num / 2;
            int r = num % 2;
            sb.append(r);
            num = q;
        }

        return sb.reverse().toString();
    }
}