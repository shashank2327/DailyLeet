class Solution {
    public int minSwapsCouples(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        int cnt = 0;
        int i = 1;
        while (i < n) {
            int prevVal = nums[i - 1];
            int idx;
            if (prevVal % 2 == 0) {
                idx = map.get(prevVal + 1);
            } else {
                idx = map.get(prevVal - 1);
            }
            if (idx == i) {
                i += 2;
                continue;
            }
            cnt++;
            map.put(nums[i], idx);
            map.put(nums[idx], i);
            swap(nums, i, idx);
            
            i = i + 2;
        }
        return cnt;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}