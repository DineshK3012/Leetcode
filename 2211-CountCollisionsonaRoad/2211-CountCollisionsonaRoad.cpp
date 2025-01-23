class Solution {
public:
    int countCollisions(string directions) {
        stack<char> stk;

        int count = 0;
        for(char ch: directions){
            if(ch == 'L'){
                if(!stk.empty()){
                    if(stk.top() == 'S'){
                        count++;
                    }else{
                        count += 2;
                        stk.pop();

                        while(!stk.empty()){
                            stk.pop();
                            count++;
                        }
                        stk.push('S');
                    }
                }
            }else if(ch == 'S'){
                if(!stk.empty()){
                    if(stk.top() == 'S'){
                        stk.pop();
                    }else{
                        while(!stk.empty()){
                            stk.pop();
                            count++;
                        }
                    }
                }

                stk.push(ch);
            }else{
                while(!stk.empty() && stk.top() == 'S'){
                    stk.pop();
                }

                stk.push(ch);
            }
        }

        return count;
    }
};