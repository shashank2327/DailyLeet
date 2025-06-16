class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE; // this will tell how close the sum is, to the target;
        int ans = -1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag) {
                break;
            }
            int j = i + 1;
            int k = n - 1;
            int req = target - nums[i];
            while (j < k) {
                int twoSum = nums[j] + nums[k];
                if (Math.abs(target - twoSum - nums[i]) < min) {
                    ans = twoSum + nums[i];
                    min = Math.abs(target - twoSum - nums[i]);
                }
                if (twoSum > req) {
                    k--;
                } else if (twoSum < req) {
                    j++;
                } else {
                    flag = true;
                    break;
                }
            }
        }

        return ans;
    }
}