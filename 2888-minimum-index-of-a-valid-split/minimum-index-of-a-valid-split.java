class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int val = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            if (map.get(nums.get(i)) > maxFreq) {
                val = nums.get(i);
                maxFreq = map.get(nums.get(i));
            }
        }

        int idx = 0;    
        int count = 0;
        boolean f1 = false;
        boolean f2 = false;

        while (idx < n - 1) {
            if (nums.get(idx) == val) count++;
            if (count > (idx + 1) / 2) {
                f1 = true;
                break;
            }
            idx++;
        }

        int remain = Math.max(maxFreq - count, 0);
        if ((n - idx - 1)/2 < remain) {
            f2 = true;
        }


        if (f1 & f2) {
            return idx;
        } else {
            return -1;
        }
    }


    // 1, 2, 3, 4, 5
}