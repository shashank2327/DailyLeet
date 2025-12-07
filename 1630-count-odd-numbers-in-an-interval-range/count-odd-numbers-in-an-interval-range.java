class Solution {
    public int countOdds(int low, int high) {
        int count = (high - low + 1) / 2;
        
        if ((high -low + 1) % 2 == 0) return count;

        if (low % 2 == 0) {
            return count;
        } else {
            return count + 1;
        }
    }
}