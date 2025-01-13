class Solution {
public:
    int minimumLength(string s) {
        int n = s.length();

        int freq[26];
        for(int i = 0; i<s.length(); i++){
            int ind = s[i] - 'a';
            freq[ind]++;

            if(freq[ind] == 3){
                n -= 2;
                freq[ind] -= 2;
            }
        }

        return n;
    }
};