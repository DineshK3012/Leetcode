class Solution {
public:
    int findSumOfDigits(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    int maximumSum(vector<int>& nums) {
        unordered_map<int, priority_queue<int>> map;

        for(int num: nums){
            int sum = findSumOfDigits(num);
            map[sum].push(num);
        }

        int ans = -1;
        for(auto& [sum, pq]: map){
            if(pq.size() >= 2){
                int first = pq.top();
                pq.pop();
                int second = pq.top();
                pq.pop();

                ans = max(ans, first + second); 
            }
        }

        return ans;
    }
};