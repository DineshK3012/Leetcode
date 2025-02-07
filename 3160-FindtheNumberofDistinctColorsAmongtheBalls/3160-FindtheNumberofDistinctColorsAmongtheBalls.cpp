class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        unordered_map<int, int> cm;
        unordered_map<int, int> balls;
        vector<int> res;

        for(vector<int>& q: queries){
            int x = q[0];
            int y = q[1];

            if(balls[x] == 0){
                cm[y]++;
            }else{
                cm[balls[x]]--;
                if (cm[balls[x]] == 0) {
                    cm.erase(balls[x]);
                }

                cm[y]++;
            }
            balls[x] = y;

            res.push_back(cm.size());
        }

        return res;
    }
};