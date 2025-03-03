class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int small = 0, equal = 0, n = nums.length;
        for(int num: nums){
            if(num == pivot){
                equal++;
            }else if(num < pivot){
                small++;
            }
        }

        int[] ans = new int[n];
        int s = 0, e = small, g = small + equal;
        for(int num: nums){
            if(num == pivot){
                ans[e++] = num;
            }else if(num < pivot){
                ans[s++] = num;
            }else{
                ans[g++] = num;
            }
        } 

        return ans;
    }
}