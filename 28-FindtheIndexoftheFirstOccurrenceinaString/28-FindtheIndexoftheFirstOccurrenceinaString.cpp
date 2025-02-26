class Solution {
public:
    int strStr(string text, string pat) {
        if(text.length() < pat.length()){
            return -1;
        }
        
        for(int i = 0; i<=(text.length() - pat.length()); i++){
            bool matched = true;
            for(int j = 0; j<pat.length(); j++){
                if(pat[j] != text[i + j]){
                    matched = false;
                    break;
                }
            }
            
            if(matched){
                return i;
            }
        }
        
        return -1;     
    }
};