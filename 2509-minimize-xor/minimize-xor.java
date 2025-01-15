class Solution {
    public int minimizeXor(int num1, int num2) {
        
        // number of set bits equal to num2;
        // x xor num1 should be minimal;

        // observation ->>>
        // 1. if number of set bits of num1 and num2 are same, then ans is num1

        // 2. if number of set bits of num2 is large then num1, then 
        // make every set bits of num1 0 and put rest of the set bits at min power

        //3. if number of set bits of num2 is less then num1, then make every
        // large power bits to 0.

        int bits = Integer.bitCount(num2);
        int result = 0;
        for (int i = 31; i >= 0 && bits > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i);
                bits--;
            }
        }
        for (int i = 0; i <= 31 && bits > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                bits--;
            }
        }

        return result;
    }
}