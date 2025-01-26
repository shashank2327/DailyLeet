class Solution {
    public int maxFrequency(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (int b : map.keySet()) {
            result = Math.max(result, kadaneAlgo(nums, k, b));
        }

        return result + map.getOrDefault(k, 0);
    }


    private int kadaneAlgo(int[] nums , int k , int b) {
        int maxGain = 0;
        int currGain = 0;
        for (int num : nums) {
            if (num == k) {
                currGain--;
            }
            if (num == b) {
                currGain++;
            }
            if (currGain < 0) currGain = 0;

            maxGain = Math.max(currGain, maxGain);
        }

        return maxGain;
    }
}