class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length; // number of elements;
        List<Integer>[] frequencyBucket = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) frequencyBucket[i] = new ArrayList<>();

        Arrays.sort(nums);
        int idx = 0;
        while (idx < n) {
            int num = nums[idx];
            int freq = 0;
            while (idx < n && nums[idx] == num) {
                freq++;
                idx++;
            }
            frequencyBucket[freq].add(num);
        }


        int[] result = new int[k];
        int index = 0;
        for (int i = n; i >= 0 && index < k; i--) {
            if (frequencyBucket[i].size() == 0) continue;
            for (int j = 0; j < frequencyBucket[i].size() && index < k; j++) {
                result[index++] = frequencyBucket[i].get(j);
            }
        }

        return result;
    }
}

// Break down;
// k most Frequent Element -> max Heap (containing freq);

// 1e5 is the maximum frequency we can have;
// make an array of 1e5 elements; every index is frequency count;
// every element of that array will be a list containing the numbers having frequency equal to idx;