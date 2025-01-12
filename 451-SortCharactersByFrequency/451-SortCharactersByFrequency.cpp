class Solution {
public:
    string frequencySort(string s) {
        map<char, int> mp;
        for(char ch: s){
            mp[ch]++;
        }

        priority_queue<pair<int, char>, vector<pair<int, char>>, less<pair<int, char>>> pq;
        for(auto m: mp){
            pq.push({m.second, m.first});
        }

        string ans;
        while(!pq.empty()){
            auto p = pq.top();
            pq.pop();

            ans.append(p.first, p.second);
        }

        return ans;
    }
};