class Solution {
    public long countBadPairs(int[] nums) {
        long bp = 0;
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;

            int gp = map.getOrDefault(diff, 0);
            bp += i - gp;

            map.put(diff, gp + 1);
        }

        return bp;
    }
}