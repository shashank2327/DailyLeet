class Solution {
public:
    int specialTriplets(vector<int>& nums) {
        int n = nums.size();
        int MOD = 1000000007;
        unordered_map<int, int> leftCount;
        unordered_map<int, int> rightCount;


        for (int num : nums) {
            rightCount[num] = rightCount[num] + 1;
        }

        long long count = 0;

        for (int j = 0; j < n; j++) {
            rightCount[nums[j]] -= 1;

            long long left = leftCount[nums[j] * 2];
            long long right = rightCount[nums[j] * 2];

            count = (count + (left * right) % MOD)% MOD;

            leftCount[nums[j]] += 1;
        }

        return (int)count;
    }
};