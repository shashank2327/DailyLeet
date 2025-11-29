class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
            int n = map.get(nums[i]).size();
            if (n >= 3){
                res = Math.min(res, 2*(map.get(nums[i]).get(n - 1)-map.get(nums[i]).get(n-3)));
            }
        }

        return (res == Integer.MAX_VALUE ? -1 : res);
    }
}