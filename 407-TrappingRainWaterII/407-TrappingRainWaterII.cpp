class Solution {
public:
    typedef pair<int, pair<int, int>> pp;
    vector<vector<int>> dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    int trapRainWater(vector<vector<int>>& hm) {
        int n = hm.size();
        int m = hm[0].size();

        priority_queue<pp, vector<pp>, greater<>> pq;
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        //adding boundary cells to the queue
        for(int r = 0; r < n; r++){
            for(int c: {0, m-1}){
                pq.push({hm[r][c], {r, c}});
                visited[r][c] = true;
            }
        }

        for(int c = 0; c < m; c++){
            for(int r: {0, n-1}){
                pq.push({hm[r][c], {r, c}});
                visited[r][c] = true;
            }
        }

        int water = 0;
        while(!pq.empty()){
            pp p = pq.top();
            pq.pop();
            int height = p.first;
            int i = p.second.first;
            int j = p.second.second;

            for(vector<int>& d: dir){
                int x = i + d[0];
                int y = j + d[1];

                if(x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]){
                    water += max(height - hm[x][y], 0);

                    pq.push({max(height, hm[x][y]), {x, y}});
                    visited[x][y] = true;
                }
            }
        }

        return water;
    }
};