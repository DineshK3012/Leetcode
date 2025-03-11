class Solution {
    private int helper(int i, int curr, int sum, int nums[], int[][] dp){
        if(curr == sum/2)   return 1;

        if(i >= nums.length || curr > sum/2)    return 0;

        if(dp[i][curr] != -1)   return dp[i][curr];

        //not take
        int ans1 = helper(i+1, curr, sum, nums, dp);
        if(ans1 == 1)   return dp[i][curr] = 1;

        //take
        int ans2 = helper(i+1, curr + nums[i], sum, nums, dp);

        return dp[i][curr] = ans2;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }

        if(sum % 2 != 0)    return false;

        int[][] dp = new int[n][sum/2+1];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(0, 0, sum, nums, dp) == 1;
    }
}