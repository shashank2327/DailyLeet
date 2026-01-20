class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int target = nums.get(i);
            int value = linearSearch(target);
            ans[i] = value;
        }

        return ans;
    }

    static int linearSearch(int target) {
        for (int i = 1; i <= target; i++) {
            if (((i)|(i+1)) ==  target) {
                return i;
            }
        }
        return -1;
    }
}