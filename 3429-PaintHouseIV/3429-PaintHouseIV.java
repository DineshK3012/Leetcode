class Solution {
    private long helper(int i, int pc, int pcm, int[][] cost, long[][][] dp){
        int n = cost.length;
        if(i * 2 >= n){
            return 0;
        }

        if(dp[i][pc+1][pcm+1] != -1){
            return dp[i][pc+1][pcm+1];
        }

        //painting
        long ans = Long.MAX_VALUE;
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(x != pc && y != pcm && x != y){
                    ans = Math.min(ans, cost[i][x] + cost[n-(i+1)][y] + helper(i+1, x, y, cost, dp));
                }
            }
        }

        return dp[i][pc+1][pcm+1] = ans;
    }

    public long minCost(int n, int[][] cost) {
        long[][][] dp = new long[n][4][4];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<4; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, -1, -1, cost, dp);
    }
}