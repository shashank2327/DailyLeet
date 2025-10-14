class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean flag = true;
        for (int num : nums) {
            xor = xor ^ num;
            if (num != 0) flag = false;
        }
        if (flag) return 0;
        if (xor == 0) return (n - 1);

        return n;
    }
}

/*
    1 2 3
     0 1
     1 0
     1 1

     1 0 
     1 1
    1 0 0 
*/