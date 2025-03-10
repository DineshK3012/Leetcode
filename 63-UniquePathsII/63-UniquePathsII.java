class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1){
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i<n; i++){
            if(grid[0][i] == 0){
                dp[i] = dp[i-1];
            }
        }

        for(int i = 1; i<m; i++){
            dp[0] = grid[i][0] == 1? 0: dp[0];
            for(int j = 1; j<n; j++){
                if(grid[i][j] == 1){
                    dp[j] = 0;
                }else{
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}