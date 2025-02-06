class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if (n < 4) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int val = nums[i] * nums[j];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        
        for (int val : map.values()) {
            if (val > 1) {
                count += (((val - 1) * val) / 2) * 8;
            }
        }

        return count;
    }
}