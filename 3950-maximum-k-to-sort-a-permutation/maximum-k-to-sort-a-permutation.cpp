class Solution {
public:
    int sortPermutation(vector<int>& nums) {
        int ans = 1<<30;
        ans--;
        for(int i = 0;i<nums.size(); ++i){
            if(nums[i]!=i)ans &= nums[i];
        }
        if(ans+1 == (1<<30))return 0;
        return ans;
    }
};