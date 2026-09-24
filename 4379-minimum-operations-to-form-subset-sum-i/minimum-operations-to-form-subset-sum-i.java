class Solution {
    public int minOperations(int[] nums, int sum) {
        int n = nums.length;
        List<List<int[]>> options = new ArrayList<>();

        for (int num : nums) {

            List<int[]> curr = new ArrayList<>();

            // Multiplications
            int val = num;
            int cnt = 0;

            while (val <= sum) {
                curr.add(new int[]{val, cnt});

                if (val > sum / 2) break;
                val *= 2;
                cnt++;
            }

            // Divisions
            val = num / 2;
            cnt = 1;

            while (val > 0) {
                curr.add(new int[]{val, cnt});
                val /= 2;
                cnt++;
            }

            options.add(curr);
        }

        int[][] memo = new int[n + 1][sum + 1];

        for (int[] row: memo) Arrays.fill(row, - 1);

        int ans = fun(options, sum, 0, memo);

        return ans >= 1e9 ? -1 : ans;
    }

    private int fun(List<List<int[]>> options, int sum, int i, int[][] memo) {

        if (sum == 0) {
            return 0;
        }

        if (sum < 0 || i == options.size()) {
            return (int) 1e9;
        }

        if (memo[i][sum] != -1) return memo[i][sum];

        // Don't use nums[i]
        int notTake = fun(options, sum, i + 1, memo);

        // Use nums[i], choosing ONE possible final value
        int take = (int) 1e9;

        for (int[] option : options.get(i)) {

            int value = option[0];
            int cost = option[1];

            if (value <= sum) {
                take = Math.min(
                    take,
                    cost + fun(options, sum - value, i + 1, memo)
                );
            }
        }

        return memo[i][sum] = Math.min(take, notTake);
    }
}