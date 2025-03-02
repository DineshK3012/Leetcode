class Solution {
public:
    vector<vector<int>> mergeArrays(vector<vector<int>>& nums1, vector<vector<int>>& nums2) {
        map<int, int> idmap;

        for (const auto& pair : nums1) {
            idmap[pair[0]] += pair[1];
        }

        for (const auto& pair : nums2) {
            idmap[pair[0]] += pair[1];
        }

        vector<vector<int>> ans;
        for (const auto& [id, value]: idmap) {
            ans.push_back({id, value});
        }

        return ans;
    }
};