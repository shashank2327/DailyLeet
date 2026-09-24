class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;

        long f_half = 0;
        long s_half = 0;

        for (int i = 0; i < n / 2; i++) {
            f_half += nums[i];
            s_half += nums[n - i - 1];
        }


        int cnt = 0;

        if (f_half > s_half) cnt++;

        int ptr1 = 0;
        int ptr2 = n / 2;

        while (ptr1 <= n - 2) {
            f_half += (nums[ptr2] - nums[ptr1]);
            s_half += (nums[ptr1] - nums[ptr2]);

            System.out.println(f_half + " " + s_half);

            if (f_half > s_half) {
                cnt++;
            }

            ptr1 = (ptr1 + 1) % n;
            ptr2 = (ptr2 + 1) % n;
        }

        return cnt;
    }
}