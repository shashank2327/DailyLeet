class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : nums) {
            int f1 = map.get(num);
            if (map.containsKey(num + 1)) {
                max = Math.max(max, f1 + map.get(num + 1));
            } else {
                continue;
            }
        }

        return max;
    }
}