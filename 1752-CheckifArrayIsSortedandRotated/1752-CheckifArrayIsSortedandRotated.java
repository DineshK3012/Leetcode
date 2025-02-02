class Solution {
    public boolean check(int[] nums) {
        boolean isRotated = false;

        int n = nums.length;
        if(nums[0] >= nums[n-1]){
            isRotated = true;
        }

        int maxDip = isRotated ? 1: 0;
        for(int i = 1; i<n; i++){   
            if(nums[i] < nums[i-1]){
                maxDip--;
            }

            if(maxDip < 0)
                return false;
        }

        return true;
    }
}