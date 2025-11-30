class Solution {

    private int reverse(int num) {
        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + num % 10;
            num /= 10;
        }
        return revNum;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int result = n;

        for (int i = n - 1; i >= 0; i--) {
            int revValue = reverse(nums[i]);
            if (map.containsKey(revValue)) {
                result = Math.min(result, map.get(revValue) - i);
            }
            map.put(nums[i], i);
        }

        return result < n ? result : -1;
    }
}