class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = num % value;
            if (val < 0) val += value;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int val = i % value;
            if (map.containsKey(val)) {
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) map.remove(val);
            } else {
                return i;
            }
        }

        return n;
    }
}

/*
    1, 0, 2, 3, 1, 3
    1, 4, 0, 6, 6, 1
*/