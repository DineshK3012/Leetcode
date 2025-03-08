class Solution {
    // private int helper(int i, int nums[], int[] dp){
    //     if(i >= nums.length)    return 0;

    //     if(dp[i] != -1) return dp[i];

    //     //not robbing the current house
    //     int ans1 = helper(i+1, nums, dp);

    //     //robbing the current house
    //     int ans2 = nums[i] + helper(i+2, nums, dp);

    //     return dp[i] = Math.max(ans1, ans2);
    // }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)  return nums[0];
        if(n == 2)  return Math.max(nums[0], nums[1]);

        int p1 = nums[0];
        int p2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n; i++){
            //not robbing the current house
            int ans1 = p2;

            //robbing the current house
            int ans2 = nums[i] + p1;

            p1 = p2;
            p2 = Math.max(ans1, ans2);
        }

        return p2;
    }
}