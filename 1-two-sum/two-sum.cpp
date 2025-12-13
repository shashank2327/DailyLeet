class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        unordered_map<int, int> valueToIdx;

        for (int i = 0; i < nums.size(); i++) {
            int currSum = nums[i];
            int remaining = target - currSum;

            if (valueToIdx.find(remaining) != valueToIdx.end()) {
                // the remaining value exit in the map
                return {valueToIdx[remaining], i};
            } else {
                valueToIdx[currSum] = i;
            }
        }

        return {-1, -1};


        // nums[i] + nums[j] = target; i and j should be different

        /*
            Take one element and sum it with all the elements except it and check whether
            the some equals target

            [2, 7, 11, 15]    target = 26

        */


        /*
            suppose we are at ith index;

            currentSum = num[i];

            remainingSum = target - currSum;

                    
            [2, 7, 11, 15]

            
        */
    }
};