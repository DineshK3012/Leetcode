class Solution {
public:
    int minimumLength(string s) {
        int n = s.length();

        unordered_map<char, int> map;
        for(int i = 0; i<s.length(); i++){
            char ch = s[i];
            map[ch]++;

            if(map[ch] == 3){
                n -= 2;
                map[ch] -= 2;
            }
        }

        return n;
    }
};