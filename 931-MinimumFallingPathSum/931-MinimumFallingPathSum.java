class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        //base case
        for(int i = 0; i<n; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<n; j++){
                int l = Math.max(0, j-1);
                int r = Math.min(n-1, j+1);

                dp[i][j] = Integer.MAX_VALUE;
                for(int k = l; k <= r; k++){
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i-1][k]);                    
                }
            }
        }   

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            ans = Math.min(ans, dp[n-1][i]);
        }

        return ans;
    }
}