class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<List<Integer>> valAndList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                valAndList.add(Arrays.asList(nums.get(i).get(j), i + 1));
            }
        } 

        valAndList.sort((l1, l2) -> l1.get(0) - l2.get(0));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, 1);
        }

        int left = 0;
        int minLeft = -1;
        int minRange = Integer.MAX_VALUE;
        int cnt = 0;

        for (int right = 0; right < valAndList.size(); right++) {
            int idx = valAndList.get(right).get(1);
            // if (map.containsKey(idx)) {
                map.put(idx, map.get(idx) - 1);
                if (map.get(idx) >= 0) {
                    cnt++;
                }
                while (cnt == n) {
                    if (valAndList.get(right).get(0) - valAndList.get(left).get(0) < minRange) {
                        minRange = valAndList.get(right).get(0) - valAndList.get(left).get(0);
                        minLeft = valAndList.get(left).get(0);
                    }
                    // if (map.containsKey(valAndList.get(left).get(1))) {
                        map.put(valAndList.get(left).get(1), map.get(valAndList.get(left).get(1)) + 1);
                        if (map.get(valAndList.get(left).get(1)) > 0) {
                            cnt--;
                        }
                    // }
                    left++;
                }
            // }
        }

        return minRange == Integer.MIN_VALUE ? new int[]{} : new int[]{minLeft, minLeft + minRange};
    }
}

// Brute force;
// take the minimum;
// take the maximum
// in given example : [min, max];
// try out all the subarrays of the given range and return the minimum;
// trying out all the subarrays is too expensive;

//---------------------------------------------------------------------------------

// make a 2D Array;

