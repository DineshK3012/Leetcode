class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        int n = numCourses;
        vector<unordered_set<int>> pr(n);
        unordered_map<int, vector<int>> adj;
        vector<int> indegree(n, 0);

        for(vector<int>& p: prerequisites){
            adj[p[0]].push_back(p[1]);

            indegree[p[1]]++;
        }

        queue<int> q;
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.push(i);
            }
        }

        while(!q.empty()){
            int u = q.front();
            q.pop();

            for(int v: adj[u]){
                indegree[v]--;
                pr[v].insert(u);

                //also inserting the prerequisites of node u into v as well
                for(int w: pr[u]){
                    pr[v].insert(w);
                }

                if(indegree[v] == 0){
                    q.push(v);
                }
            }
        }

        vector<bool> ans;
        for(vector<int>& q: queries){
            if(pr[q[1]].find(q[0]) != pr[q[1]].end()){
                ans.push_back(true);
            }else{
                ans.push_back(false);
            }
        }

        return ans;
    }
};