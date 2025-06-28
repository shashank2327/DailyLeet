class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostKDistinct(nums, k) - atmostKDistinct(nums, k - 1);
    }
    public int atmostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int n = nums.length;
        int left = 0;
        int right = 0;
        int subarrayCnt = 0;
        while (right < n) {
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);
            while (frequencyMap.size() > k) {
                frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);
                if (frequencyMap.get(nums[left]) == 0) {
                    frequencyMap.remove(nums[left]);
                }
                left++;
            }
            subarrayCnt += right - left + 1;
            right++;
        }

        return subarrayCnt;
    }
}
//           v
//                v
// [1, 2, 1, 3, 4], k = 3;   // exactly k  --> atmost(k) - atmost(k - 1);
    
/*
// at most k distinct;
1
1 2
1 2 1
1 2 1 3
2
2 1
2 1 3
1
1 3
1 3 4
3
3 4
4
// at most k - 1 elements
1
1 2
1 2 1
2
2 1
1
1 3
3
3 4
4
*/