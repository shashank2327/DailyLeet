class Solution {
    public int minBitFlips(int start, int goal) {
        int val = start^goal;
        int count = 0;
        while (val != 0) {
            if ((val & 1) > 0) {    
                count++;
            }
            val = val >> 1; 
        }
        return count;
    }
}