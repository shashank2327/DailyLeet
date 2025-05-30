class Solution {
    public int hammingDistance(int x, int y) {
        int val = x ^ y; // The ith bit will be 1 if x's and y's ith bit were different;
        int cnt = 0;
        while (val > 0) {
            if ((val & 1) > 0) {
                cnt++;
            }
            val =  val >> 1;
        }

        return cnt;
    }
}