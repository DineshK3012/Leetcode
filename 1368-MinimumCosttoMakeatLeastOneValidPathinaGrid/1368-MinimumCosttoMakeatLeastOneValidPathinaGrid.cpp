class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        int d[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        vector<vector<int>> cost(n, vector<int>(m, INT_MAX));
        priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<>> pq;
        cost[0][0] = 0;
        pq.emplace(0, 0, 0);


        while(!pq.empty()){
            auto [c, i, j] = pq.top();
            pq.pop();

            if(i == n-1 && j == m-1){
                return c;
            }

            for(int x = 0; x<4; x++){
                int ni = i + d[x][0];
                int nj = j + d[x][1];

                int newCost = (grid[i][j] == x+1) ? 0: 1;

                if(ni >= 0 && nj >= 0 && ni < n && nj < m && c + newCost < cost[ni][nj]){
                    cost[ni][nj] = newCost + cost[i][j];

                    pq.emplace(cost[ni][nj], ni, nj);
                }
            }
        }


        return cost[n-1][m-1];
    }
};