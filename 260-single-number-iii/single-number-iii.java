class Solution {
    public int[] singleNumber(int[] nums) {
        

        long xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // taking out the first bit which is unccommon to both of them
        
        xor = (xor & (xor - 1)) ^ xor;
        
        long b1 = 0;
        long b2 = 0;
        
        for (int num : nums) {
            if ((num & (int)xor) == 0) {
                b1 = b1 ^ num;
            } else {
                b2 = b2 ^ num;
            }
        }
        
        return new int[]{(int)b1, (int)b2};
    }
}