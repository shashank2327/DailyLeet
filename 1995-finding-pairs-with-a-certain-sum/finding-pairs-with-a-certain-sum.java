class FindSumPairs {

    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int freq = map.getOrDefault(nums2[index], 0);

        if (freq > 1) {
            map.put(nums2[index], freq - 1);
        } else {
            if (map.containsKey(nums2[index])) {
                map.remove(nums2[index]);
            }
        }

        nums2[index] += val;

        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);

    }
    
    public int count(int tot) {
        int cnt = 0;
        for (int i = 0; i < nums1.length; i++) {
            int req = tot - nums1[i];
            cnt += map.getOrDefault(req, 0);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */