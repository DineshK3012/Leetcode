class Solution {
public:
    bool canBeValid(string s, string l) {
        if(s.length() % 2 != 0){
            return false;
        }

        int opens = 0;
        for(int i = 0; i<s.length(); i++){
            if(l[i] == '0' || s[i] == '('){
                opens++;
            }else{
                opens--;

                if(opens < 0){
                    return false;
                }
            }
        }

        int close = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(l[i] == '0' || s[i] == ')'){
                close++;
            }else{
                close--;

                if(close < 0){
                    return false;
                }
            }
        }

        return true;
    }
};