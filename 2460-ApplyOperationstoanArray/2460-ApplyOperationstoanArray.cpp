class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        vector<int> ans;
        for(int i = 0; i<nums.size()-1; i++){
            if(nums[i] == 0)
                continue;

            if(nums[i] == nums[i+1]){
                ans.push_back(nums[i] * 2);
                nums[i+1] = 0;
            }else if(nums[i] != 0){
                ans.push_back(nums[i]);
            }
        }
        if(nums.back() != 0){
            ans.push_back(nums.back());
        }

        while(ans.size() < nums.size()){
            ans.push_back(0);
        }

        return ans;
    }
};