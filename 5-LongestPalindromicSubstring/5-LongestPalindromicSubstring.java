class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];
        //substring of one length - base case
        for(int i = 0; i<n; i++){
            dp[i][i] = true;
        }
        
        int start = 0, ans = 1;
        for(int k = 2; k <= n; k++){
            for(int i = 0; i<=n-k; i++){
                int j = i+k-1;

                //if length of substring is 2
                if(k == 2){
                    if(s.charAt(i) == s.charAt(j))  {
                        dp[i][j] = true;
                        start = i;
                        ans = 2;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i+1][j-1]){
                            dp[i][j] = true;
                            start = i;

                            ans = Math.max(ans, k);
                        }
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return s.substring(start, start + ans);
    }
}