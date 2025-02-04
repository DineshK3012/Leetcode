class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = 0;
        int curr = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                curr += nums[i];
            }else{
                ans = Math.max(ans, curr);
                curr = nums[i]; 
            }
        }

        return ans = Math.max(ans, curr);
    }
}