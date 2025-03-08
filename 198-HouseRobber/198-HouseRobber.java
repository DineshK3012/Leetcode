class Solution {
    private int helper(int i, int nums[], int[] dp){
        if(i >= nums.length)    return 0;

        if(dp[i] != -1) return dp[i];

        //not robbing the current house
        int ans1 = helper(i+1, nums, dp);

        //robbing the current house
        int ans2 = nums[i] + helper(i+2, nums, dp);

        return dp[i] = Math.max(ans1, ans2);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, nums, dp);
    }
}