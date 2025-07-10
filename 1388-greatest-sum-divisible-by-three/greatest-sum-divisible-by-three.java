class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int total = 0;
        List<Integer>[] mod = new ArrayList[3]; 
        for (int i = 0; i < 3; i++) {
            mod[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            total += nums[i];
            if (nums[i] % 3 == 0) {
                mod[0].add(nums[i]);
            } else if (nums[i] % 3 == 1) {
                mod[1].add(nums[i]);
            } else {
                mod[2].add(nums[i]);
            }
        }

        if (total % 3 == 0) {
            return total;
        }
        int modIdx = total % 3;

        if (modIdx == 1) {
            int case1 = mod[1].size() > 0 ? mod[1].get(0) : Integer.MAX_VALUE;
            int case2 = mod[2].size() > 1 ? mod[2].get(0) + mod[2].get(1) : Integer.MAX_VALUE;

            if (case1 == -1 && case2 == -1) {
                return 0;
            } else {
                return total - Math.min(case1, case2);
            }
        }


        if (modIdx == 2) {
            int case1 = mod[2].size() > 0 ? mod[2].get(0) : Integer.MAX_VALUE;
            int case2 = mod[1].size() > 1 ? mod[1].get(0) + mod[1].get(1) : Integer.MAX_VALUE;

            if (case1 == -1 && case2 == -1) {
                return 0;
            } else {

                return total - Math.min(case1, case2);
            }
        }



        return 0;
    }
}