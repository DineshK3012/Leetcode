class Solution {
public:
    string removeOccurrences(string s, string part) {
        string str = s;
        int indx = str.find(part);
        while(indx != string::npos){
            str.replace(indx, part.length(), "");

            indx = str.find(part);
        }

        return str;
    }
};