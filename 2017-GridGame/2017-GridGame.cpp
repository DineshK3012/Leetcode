class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        int n = grid[0].size();
        vector<long long> ps1(n+1, 0);
        vector<long long> ps2(n+1, 0);
        for(int i = 0; i<n; i++){
            ps1[i+1] = ps1[i] + grid[0][i];
            ps2[i+1] = ps2[i] + grid[1][i];
        }

        long long ans = LONG_MAX;
        for(int i = 0; i<n; i++){
            long long sum = ps1[i+1] + ps2[n] - ps2[i]; 

            long long s1 = ps1[n] - ps1[i+1];
            long long s2 = ps2[i];

            ans = min(ans, max(s1, s2));
        }

        return ans;
    }
};