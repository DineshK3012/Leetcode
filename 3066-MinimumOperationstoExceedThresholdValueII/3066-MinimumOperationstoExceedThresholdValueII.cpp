class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        priority_queue<long long, vector<long long>, greater<long long>> pq;
        for(int num: nums){
            pq.push(num);
        }

        int count = 0;
        while(!pq.empty() && pq.top() < k && pq.size() >= 2){
            count++;

            long long first = pq.top();
            pq.pop();
            long long second = pq.top();
            pq.pop();

            pq.push(min(first, second) * 2 + max(first, second));
        }

        return count;
    }
};