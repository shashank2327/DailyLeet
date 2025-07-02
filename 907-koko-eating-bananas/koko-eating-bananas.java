class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length; // number of piles of bananas;
        Arrays.sort(piles);
        int low = 1;
        int high = piles[n - 1];

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // if possible to eat within h hrs. // decrease the speed;
            // else increase the speed;
            if (possible(piles, h, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public boolean possible(int[] piles, int h, int speed) {
        int n = piles.length;
        long timeRequired = 0;
        for (int i = 0; i < n; i++) {
            timeRequired += (piles[i] + speed - 1) / speed;
        }

        if (timeRequired <= h) {
            return true;
        } else {
            return false;
        }
    }
}