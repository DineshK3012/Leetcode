class KthLargest {
priority_queue<int, vector<int>, greater<>> pq;
int limit;

public:
    KthLargest(int k, vector<int>& nums) {
        limit = k;

        for(int num: nums){
            pq.push(num);

            if(pq.size() > limit){
                pq.pop();
            }
        }
    }
    
    int add(int val) {
        pq.push(val);

        if(pq.size() > limit){
            pq.pop();
        }

        return pq.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */