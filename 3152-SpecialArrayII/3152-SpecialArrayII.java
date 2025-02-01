class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int n = nums.length;
        int[] mr = new int[n];

        mr[n-1] = n-1;
        for(int i = n-2; i>=0; i--){
            if(nums[i] % 2 != nums[i+1] % 2){
                mr[i] = mr[i+1];
            }else{
                mr[i] = i;
            }
        }

        for(int i = 0; i<queries.length; i++){
            int[] q = queries[i];
            ans[i] = q[1] <= mr[q[0]];
        }

        return ans;
    }
}