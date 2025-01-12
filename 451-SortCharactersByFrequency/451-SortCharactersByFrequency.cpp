class Solution {
public:
    string frequencySort(string s) {
        vector<int> freq(128, 0);

        for(char ch: s){
            freq[ch]++;
        }

        vector<pair<int,int>> arr;
        for(char ch: s){
            arr.push_back({freq[ch], ch});
        }

        sort(arr.begin(), arr.end(), [](const pair<int, char> &p1, const pair<int, char> & p2){
            if(p1.first == p2.first){
                return p1.second > p2.second;
            }

            return p1.first > p2.first;
        });

        string ans = "";
        for(pair<int, char> p: arr){
            ans += p.second;
        }

        return ans;
    }
};