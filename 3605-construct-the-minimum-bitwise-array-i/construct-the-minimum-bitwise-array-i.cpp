class Solution {
public:
    vector<int> minBitwiseArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans;

        for (int i=0; i<n; i++){
            if (nums[i] == 2){
                ans.push_back(-1);
                continue;
            }

            int l = 0;
            int copy = nums[i];
            while (copy & 1 == 1){
                l++;
                copy >>= 1;
            }
            l = l-1;
            int mask = 1 << l;
            ans.push_back(nums[i]^mask);
        }

        return ans;
    }
};