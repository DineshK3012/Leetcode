class Solution {
    private int helper(int i, int j, String s, int k, int[][][] dp){
        //base cases
        if(i == j){
            return 1;
        }

        if(i > j){
            return 0;
        }
        
        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j][k] = 2 + helper(i+1, j-1, s, k, dp);
        }else{
            int x = s.charAt(i) - 'a';
            int y = s.charAt(j) - 'a';

            int mod = Math.min((x - y + 26) % 26, (y - x + 26) % 26);
            
            //without applying operation to match these
            int ans1 = Math.max(helper(i+1, j, s, k, dp), helper(i, j-1, s, k, dp));

            //if possible then making then same
            int ans2 = 0;
            if(mod <= k){
                ans2 = 2 + helper(i+1, j-1, s, k - mod, dp);
            }

            return dp[i][j][k] = Math.max(ans1, ans2);
        }
    }

    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();

        int[][][] dp = new int[n][n][k+1];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, s.length() - 1, s, k, dp);
    }
}