class Solution {
    
    public int change(int x, int[] coins) {
        int n = coins.length;
        int[] nextState = new int[x + 1];
        nextState[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            int[] currentState = new int[x + 1];
            currentState[0] = 1;
            for (int j = 1; j <= x; j++) {
                int skip = nextState[j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = currentState[j - coins[i]];
                }
                currentState[j] = (skip + pick);
            }
            nextState = currentState;
        }
        return nextState[x];
    }
}