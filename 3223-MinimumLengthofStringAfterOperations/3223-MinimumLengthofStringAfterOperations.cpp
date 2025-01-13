class Solution {
public:
    int minimumLength(string s) {
        int n = s.length();

        int freq[26];
        for(char ch: s){
            int ind = ch - 'a';
            freq[ind]++;

            if(freq[ind] == 3){
                n -= 2;
                freq[ind] -= 2;
            }
        }

        return n;
    }
};