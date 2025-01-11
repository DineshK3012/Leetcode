class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        for(int num: nums){
            map[num]++;
        }   

        int count = 0;
        unordered_set<int> set;
        for(int num: nums){
            if(set.count(num) > 0)
                continue;

            if(k == 0){
                count += (map[num] > 1) ? 1: 0;
                map.erase(num);
                continue;
            }

            if(map[num+k] > 0){
                count++;
            }

            if(map[num-k] > 0){
                count++;
            }

            set.insert(num);
            map.erase(num);
        }

        return count;
    }
};