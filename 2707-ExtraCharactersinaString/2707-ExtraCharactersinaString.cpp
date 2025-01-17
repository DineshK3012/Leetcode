class Solution {
public:
    int helper(int i, string s, unordered_set<string> dict, vector<int>& dp){
        if(i == s.length()){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }

        int ans = INT_MAX;
        //not including the current character
        ans = min(ans, 1 + helper(i+1, s, dict, dp));
        
        //including the current character
        string str = "";
        for(int j = i; j<s.length(); j++){
            str =  str + s[j];
            if(dict.find(str) != dict.end()){
                ans = min(ans, helper(j+1, s, dict, dp));
            }
        }

        return dp[i] = ans;
    }

    int minExtraChar(string s, vector<string>& dictionary) {
        unordered_set<string> dict;
        for(string word: dictionary){
            dict.insert(word);
        }

        int n = s.length();
        vector<int> dp(n, -1);
        return helper(0, s, dict, dp);
    }
};