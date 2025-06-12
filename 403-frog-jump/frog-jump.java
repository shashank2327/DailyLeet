import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        // Map stone position to its index
        Map<Integer, Integer> stoneMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            stoneMap.put(stones[i], i);
        }

        Map<String, Boolean> memo = new HashMap<>();

        return dfs(stones, 0, 0, stoneMap, memo);
    }

    private boolean dfs(int[] stones, int i, int prevJump, Map<Integer, Integer> map, Map<String, Boolean> memo) {

        if (i == stones.length - 1) return true;

        String key = i + "," + prevJump;
        if (memo.containsKey(key)) return memo.get(key);

        // Try jumps: prevJump - 1, prevJump, prevJump + 1
        for (int jump = prevJump - 1; jump <= prevJump + 1; jump++) {
            if (jump <= 0) continue;

            int nextPos = stones[i] + jump;
            if (map.containsKey(nextPos)) {
                int nextIndex = map.get(nextPos);
                if (dfs(stones, nextIndex, jump, map, memo)) {
                    memo.put(key, true);
                    return true;
                }
            }
        }

        memo.put(key, false);
        return false;
    }
}
