class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int longest = 1;
        int curr = 1;
        int n = nums.length;
        for(int i = 1; i<n; i++){
            if(nums[i] > nums[i-1]){
                curr++;

                longest = Math.max(longest, curr);
            }else{
                curr = 1;
            }
        }

        curr = 1;
        for(int i = 1; i<n; i++){
            if(nums[i] < nums[i-1]){
                curr++;

                longest = Math.max(longest, curr);
            }else{
                curr = 1;
            }
        }


        return longest;
    }
}