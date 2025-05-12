class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, - 1);
        return memoSol(-1, cost, memo);
    }
    private int minRecur(int index, int[] cost) {
        if (index >= cost.length - 1) return 0;

        int oneJump = 0;
        int twoJump = 0;

        if (index + 1 <= cost.length - 1) {
            oneJump = cost[index + 1] + minRecur(index + 1, cost);
        }
        if (index + 2 <= cost.length - 1) {
            twoJump = cost[index + 2] + minRecur(index + 2, cost);
        }
        

        return Math.min(oneJump, twoJump);

    }

    private int memoSol(int index, int[] cost, int[] memo) {
        if (index >= cost.length - 1) return 0;
        if (index >= 0 && memo[index] != -1) return memo[index];
        int oneJump = 0;
        int twoJump = 0;

        if (index + 1 <= cost.length - 1) {
            oneJump = cost[index + 1] + memoSol(index + 1, cost, memo);
        }
        if (index + 2 <= cost.length - 1) {
            twoJump = cost[index + 2] + memoSol(index + 2, cost, memo);
        }
        
        if (index >= 0) {
            memo[index] = Math.min(oneJump, twoJump);
        }
        return  Math.min(oneJump, twoJump);
    }
}