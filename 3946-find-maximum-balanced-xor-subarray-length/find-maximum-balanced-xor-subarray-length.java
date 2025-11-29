class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", -1);
        int pXor = 0;
        int balance = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            pXor ^= nums[i];
            if (nums[i] % 2 == 0) {
                balance++;
            } else {
                balance--;
            }
            String k = pXor + "," + balance;
            if (map.containsKey(k)) {
                int prevIdx = map.get(k);
                max = Math.max(max, i - prevIdx);
            } else {
                map.put(k, i);
            }
        }

        return max;
    }
}