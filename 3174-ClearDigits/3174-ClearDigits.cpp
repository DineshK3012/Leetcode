class Solution {
public:
    string clearDigits(string s) {
        stack<char> stk;

        for(char ch: s){
            if(ch >= '0' && ch <= '9'){
                stk.pop();
            }else{
                stk.push(ch);
            }
        }

        string ans = "";
        while(!stk.empty()){
            ans = stk.top() + ans;
            stk.pop();
        }

        return ans;
    }
};