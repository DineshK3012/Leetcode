class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        int[] curr = new int[n];

        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i<n; i++){
            curr = new int[n];
            curr[0] = dp[0] + triangle.get(i).get(0);
            for(int j = 1; j < (i+1); j++){  
                if(j == i){
                    curr[j] = triangle.get(i).get(j) + dp[j-1];
                }else{
                    curr[j] = triangle.get(i).get(j) + Math.min(dp[j-1], dp[j]);
                }
            }

            dp = curr;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            min = Math.min(min, dp[i]);
        }

        return min;
    }
}