class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end(), greater<>());
        sort(s.begin(), s.end(), greater<>());

        int i = 0, j = 0;
        int count = 0;
        while(i < g.size() && j < s.size()){
            if(s[j] >= g[i]){
                j++;
                count++;
            }

            i++;
        }

        return count;
    }
};