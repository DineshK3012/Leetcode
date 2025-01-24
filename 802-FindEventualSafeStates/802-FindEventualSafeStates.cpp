class Solution {
public:
    bool dfs(int i, vector<vector<int>>& graph, vector<bool>& visited, vector<bool>& path_visited){
        visited[i] = true;
        path_visited[i] = true;

        for(int j: graph[i]){
            if(!visited[j]){
                if(dfs(j, graph, visited, path_visited)){
                    return true;
                }
            }else if(path_visited[j]){
                return true;
            }
        }

        path_visited[i] = false;

        return false;
    }

    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<bool> visited(n, false);
        vector<bool> path_visited(n, false);

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(i, graph, visited, path_visited);
            }
        }

        vector<int> ans;
        for(int i = 0; i<n; i++){
            if(!path_visited[i]){
                ans.push_back(i);
            }
        }

        return ans;
    }
};