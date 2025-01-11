class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> min_heap;

        for(int i = 0; i<nums.size(); i++){
            min_heap.push({nums[i], i});

            if(min_heap.size() > k){
                min_heap.pop();
            }

        }

        map<int, int> m;
        while(!min_heap.empty()){
            m.insert({min_heap.top().second, min_heap.top().first});
            min_heap.pop();
        }

        vector<int> ans;
        for(auto& x: m){
            ans.push_back(x.second);
        }

        return ans;
    }
};