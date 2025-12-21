class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
};

/*
    a ^ a = 0;
    and taking xor with 0 have no effect.
*/