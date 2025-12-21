class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int res = 0;

        // we are going to every 32 positions;
        for (int i = 0; i <= 31; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;  
            }

            sum = sum % 3;  // the sum value will either come 0 or 1;
            res = res | (sum << i);  // we setting the ith bit;
        }

        return res;
    }
};

/*
    [6, 6, 6, 3, 3, 3, 4]  = 4

    1 1 0
    1 1 0
    1 1 0
    0 1 1
    0 1 1
    0 1 1
    1 0 0
    4 6 3
    1 0 0  = 4 
*/