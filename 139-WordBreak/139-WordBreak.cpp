class Solution {
public:
    int helper(int i, string s, unordered_set<string> dict, vector<int>& dp){
        if(i == s.length()){
            return true;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }

        int ans = 0;
        string str = "";
        for(int j = i; j<s.length(); j++){
            str =  str + s[j];
            if(dict.find(str) != dict.end()){
                ans = helper(j+1, s, dict, dp);

                if(ans == 1){
                    break;
                }
            }
        }

        return dp[i] = ans;
    }

    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> dict;
        for(string word: wordDict){
            dict.insert(word);
        }

        int n = s.length();
        vector<int> dp(n, -1);
        return helper(0, s, dict, dp);
    }
};