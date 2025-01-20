class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();

        vector<int> rowFreq(n, 0);
        vector<int> colFreq(m, 0);

        unordered_map<int, pair<int, int>> map;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                map[mat[i][j]] = {i, j};
            }
        }

        for(int x = 0; x < arr.size(); x++){
            auto [i, j] = map[arr[x]];

            rowFreq[i]++;   
            colFreq[j]++;

            if(rowFreq[i] == m || colFreq[j] == n){
                return x;
            }
        }

        return -1;
    }
};