class Tuple {
    int health;
    int row;
    int col;

    public Tuple(int health, int row, int col) {
        this.health = health;
        this.row = row;
        this.col = col;
    }
}
class Solution {

    // for going in four directions;
    int[] delRow = {1, -1, 0, 0};
    int[] delCol = {0, 0, 1, -1};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        // keep tracks of maximum health for each row and col;
        int[][] healthTracker = new int[n][m];
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>((t1, t2) -> t2.health - t1.health);
        healthTracker[0][0] = health - grid.get(0).get(0);  
        maxHeap.offer(new Tuple(healthTracker[0][0], 0, 0));


        while (!maxHeap.isEmpty()) {
            Tuple token = maxHeap.poll();
            int healthRemain = token.health;
            int row = token.row;
            int col = token.col;

            for (int i = 0; i < 4; i++) {
                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (healthRemain - grid.get(nr).get(nc) > healthTracker[nr][nc]) {
                        healthTracker[nr][nc] = healthRemain - grid.get(nr).get(nc);
                        maxHeap.offer(new Tuple(healthTracker[nr][nc], nr, nc));
                    }
                }
            }
        }

        return healthTracker[n - 1][m - 1] >= 1;
    }
}