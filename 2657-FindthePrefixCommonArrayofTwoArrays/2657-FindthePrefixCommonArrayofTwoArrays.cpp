class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        unordered_set<int> set;

        vector<int> ans(A.size(), 0);
        for(int i = 0; i<A.size(); i++){
            set.insert(A[i]);

            for(int j = 0; j<=i; j++){
                if(set.find(B[j]) != set.end()){
                    ans[i]++;
                }
            }
        }

        return ans;
    }
};