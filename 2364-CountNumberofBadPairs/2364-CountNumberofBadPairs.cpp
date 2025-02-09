class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        long long ans = 0;
        unordered_map<int, int> map;

        long long n = nums.size();
        for(int i = 0; i<n; i++){
            int diff = nums[i] - i;

            if(map.find(diff) != map.end()){
                ans += map[diff];
            }

            map[diff]++;
        }

        long long totalPairs = (n * (n-1))/2;

        return (totalPairs - ans);
    }
};