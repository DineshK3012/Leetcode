class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        int[] curr = new int[n];

        //base case
        for(int i = 0; i<n; i++){
            dp[i] = matrix[0][i];
        }

        for(int i = 1; i<n; i++){
            curr = new int[n];
            Arrays.fill(curr, Integer.MAX_VALUE);

            for(int j = 0; j<n; j++){
                int l = Math.max(0, j-1);
                int r = Math.min(n-1, j+1);

                for(int k = l; k <= r; k++){
                    curr[j] = Math.min(curr[j], matrix[i][j] + dp[k]);                    
                }
            }

            dp = curr;
        }   

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }
}