class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums, target);
    }


    int countPartitions(int[] a, int d) {
        int n = a.length;
        int totSum = 0;
        for(int i=0 ; i<n;i++){
            totSum += a[i];
        }

        if(totSum-d <0 || (totSum-d)%2==1 ) return 0;
    
        return findWays(a,(totSum-d)/2);
        
    }
    
    
    static int findWays(int[] num, int tar){
        int n = num.length;
        Arrays.sort(num);
        int dp[][] = new int[n][tar+1];
    
        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick
    
        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick
    
        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){
            
                int notTaken = dp[ind-1][target];
    
                int taken = 0;
                if(num[ind]<=target) {
                    taken = dp[ind-1][target-num[ind]];   
                }
                dp[ind][target]= (notTaken + taken);
            }
        }
        return dp[n-1][tar];
    }
}