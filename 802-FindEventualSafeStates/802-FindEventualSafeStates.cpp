class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<vector<int>> rgraph(n);
        vector<int> indegree(n, 0);
        for(int i = 0; i<n; i++){
            for(int j: graph[i]){
                rgraph[j].push_back(i);

                indegree[i]++;
            }
        }

        queue<int> q;
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.push(i);
            }
        }

        vector<bool> safeNodes(n, 0);
        while(!q.empty()){
            int u = q.front();
            q.pop();
            safeNodes[u] = true;

            for(int v: rgraph[u]){
                indegree[v]--;

                if(indegree[v] == 0){
                    q.push(v);
                }
            }
        }
        
        vector<int> ans;
        for(int i = 0; i<n; i++){
            if(safeNodes[i]){
                ans.push_back(i);
            }
        }

        return ans;
    }
};