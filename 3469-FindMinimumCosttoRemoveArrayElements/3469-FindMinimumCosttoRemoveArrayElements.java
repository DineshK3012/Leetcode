class Solution {
    private int helper(int i, int p, int[] nums, int[][] dp){
        //base case 1 - only one number left previously
        if(i >= nums.length){
            return p == -1 ? 0: nums[p];
        }

        //base case 2 -> only two or last number left
        if(i == nums.length - 1){
            return p == -1 ? nums[i] : Math.max(nums[i], nums[p]);
        }                           

        //repeated case
        if(dp[i][p+1] != -1){
            return dp[i][p+1];
        }

        int ans1 = Math.max(nums[i], nums[i+1]) + helper(i+2, p, nums, dp);
        int ans2 = (int)(1e7), ans3 = (int)(1e7);
        if(p != -1){
            ans2 = Math.max(nums[i], nums[p]) + helper(i+1, -1, nums, dp);
            ans3 = Math.max(nums[i+1], nums[p]) + helper(i+2, i, nums, dp);
        }else if(i <= nums.length - 3){
            ans2 = Math.max(nums[i], nums[i+2]) + helper(i+3, i+1, nums, dp);
            ans3 = Math.max(nums[i+1], nums[i+2]) + helper(i+3, i, nums, dp);
        }

        return dp[i][p+1] = Math.min(ans1, Math.min(ans2, ans3));
    }

    public int minCost(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(0, -1, nums, dp);
    }
}