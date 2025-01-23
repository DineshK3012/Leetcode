class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();

        unordered_set<int> ans;
        //checking rows
        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    count++;
                }

                if(count > 1){
                    break;
                }
            }

            if(count > 1){
                for(int j = 0; j<m; j++){
                    if(grid[i][j] == 1){
                        ans.insert(i*m + j);
                    }
                }
            }
        }
          
        for(int j = 0; j<m; j++){
            int count = 0;
            for(int i = 0; i<n; i++){
                if(grid[i][j] == 1){
                    count++;
                }

                if(count > 1){
                    break;
                }
            }

            if(count > 1){
                for(int i = 0; i<n; i++){
                    if(grid[i][j] == 1){
                        ans.insert(i*m + j);
                    }
                }
            }
        }

        return ans.size();
    }
};