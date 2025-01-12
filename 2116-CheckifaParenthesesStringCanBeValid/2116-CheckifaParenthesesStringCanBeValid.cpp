class Solution {
public:
    bool canBeValid(string s, string l) {
        if(s.length() % 2 != 0){
            return false;
        }

        stack<int> open;
        stack<int> both;
        for(int i = 0; i<s.length(); i++){
            if(l[i] == '0'){
                both.push(i);
            }else if(s[i] == '('){
                open.push(i);
            }else{
                if(open.size() > 0){
                    open.pop();
                    continue;
                }

                if(both.size() > 0){
                    both.pop();
                    continue;
                }

                return false;
            }
        }

        while(!open.empty()){
            if(!both.empty() && both.top() > open.top()){
                both.pop();
                open.pop();
            }else{
                return false;
            }
        }

        return both.size() % 2 == 0;
    }
};