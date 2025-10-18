class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int prevValue = Integer.MIN_VALUE;
        for (int num : nums) {
            int lowerLimit = Math.max(num - k, prevValue + 1);
            int upperLimit = num + k;

            int curr = Math.min(lowerLimit, upperLimit);
            
            if (curr > prevValue) {
                cnt++;
                prevValue = curr;
            }
        }

        return cnt;
    }
}

/*
    1   2  2  3  3  4
    -2 -2  -1 -1  0  0

    -1 0 1 2 3 4

    kdash > k
    kdash = -k

    1   1   1  1  1  1  1  1   5  5  5
   -3  -2  -1  0  1  2  3  -3  1 2   3

    -2  -1  0  1  2  3  4  -2  
*/