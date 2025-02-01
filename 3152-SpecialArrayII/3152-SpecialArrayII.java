class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int n = nums.length;
        int[] ps = new int[n];

        for(int i = 1; i<n; i++){
            if(nums[i] % 2 == nums[i-1] % 2){
                ps[i] = ps[i-1]+1;
            }else{
                ps[i] = ps[i-1];
            }
        }

        for(int i = 0; i<queries.length; i++){
            int[] q = queries[i];
            ans[i] = (ps[q[1]] - ps[q[0]]) == 0;
        }

        return ans;
    }
}