class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        int d[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        vector<vector<int>> cost(n, vector<int>(m, INT_MAX));
        deque<pair<int, int>> dq;
        cost[0][0] = 0;
        dq.push_front({0, 0});

        while(!dq.empty()){
            auto [i, j] = dq.front();
            dq.pop_front();

            if(i == n-1 && j == m-1){
                return cost[i][j];
            }

            for(int x = 0; x<4; x++){
                int ni = i + d[x][0];
                int nj = j + d[x][1];

                int newCost = (grid[i][j] == x+1) ? 0: 1;

                if(ni >= 0 && nj >= 0 && ni < n && nj < m && cost[i][j] + newCost < cost[ni][nj]){
                    cost[ni][nj] = newCost + cost[i][j];

                    if(newCost == 0){
                        dq.push_front({ni, nj});
                    }else{
                        dq.push_back({ni, nj});
                    }
                }
            }
        }


        return cost[n-1][m-1];
    }
};