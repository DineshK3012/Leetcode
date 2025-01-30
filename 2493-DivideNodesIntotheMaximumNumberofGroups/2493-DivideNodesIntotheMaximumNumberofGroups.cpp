class Solution {
public:
    bool isBipartite(int curr, unordered_map<int, vector<int>>&adj, vector<int>& colors, int currColor){
        colors[curr] = currColor;

        for(int& ngbr: adj[curr]){
            if(colors[ngbr] == colors[curr]){
                return false;
            }

            if(colors[ngbr] == -1){
                if(!isBipartite(ngbr, adj, colors, 1 - currColor)){
                    return false;
                }
            }
        }

        return true;
    }

    int bfs(int i, unordered_map<int, vector<int>> adj, int n){
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(i);
        visited[i] = true;
        int level = 0;
        while(!q.empty()){
            int s = q.size();
            for(int j = 0; j<s; j++){
                int u = q.front();
                q.pop();

                for(int& ngbr: adj[u]){
                    if(visited[ngbr])
                        continue;

                    q.push(ngbr);
                    visited[ngbr] = true;
                }
            }

            level++;
        }

        return level;
    }

    int getMaxFromComponent(int i, unordered_map<int, vector<int>>& adj, vector<bool>& visited, vector<int>& levels){
        int maxGrp = levels[i];
        visited[i] = true;

        for(int& ngbr: adj[i]){
            if(!visited[ngbr]){
                maxGrp = max(maxGrp, getMaxFromComponent(ngbr, adj, visited, levels));
            }
        }

        return maxGrp;
    }

    int magnificentSets(int n, vector<vector<int>>& edges) {
        unordered_map<int, vector<int>> adj;

        for(vector<int>& e: edges){
            int u = e[0] - 1, v = e[1] - 1;

            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        //check for bipartite
        vector<int> colors(n, -1);
        for(int i = 0; i<n; i++){
            if(colors[i] == -1){
                if(!isBipartite(i, adj, colors, 1)){
                    return -1;
                }
            }
        }

        //bfs on all nodes
        vector<int> levels(n, 0);
        for(int i = 0; i<n; i++){
            levels[i] = bfs(i, adj, n);
        }

        int ans = 0;
        vector<bool> visited(n, false);
        for(int i = 0; i<n; i++){   
            if(!visited[i]){
                ans += getMaxFromComponent(i, adj, visited, levels);
            }
        }
       
        return ans;
    }
};