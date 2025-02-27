class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        int ans = 0;
        unordered_set<int> set;
        for(int x: arr){
            set.insert(x);
        }

        for(int i = 0; i<arr.size() - 2; i++){
            for(int j = i+1; j<arr.size()-1; j++){
                int count = 2;
                if(ans >= (count + arr.size() - j)){
                    break;
                
                }
                int prev = arr[i];
                int next = arr[j];

                while(set.find(prev+next) != set.end()){
                    int temp = prev + next;
                    prev = next;
                    next = temp;
                    count++;
                }

                if(count >= 3){
                    ans = max(ans, count);
                }
            }
        }

        return ans;
    }
};