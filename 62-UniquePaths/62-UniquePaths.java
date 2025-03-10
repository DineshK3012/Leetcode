class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        int[] curr = new int[n];

        for(int i = 0; i<n; i++){
            dp[i] = 1;
        }

        for(int i = 1; i<m; i++){
            curr[0] = 1;
            for(int j = 1; j<n; j++){
                curr[j] = dp[j] + curr[j-1];
            }

            dp = curr;
        }

        return dp[n-1];
    }
}