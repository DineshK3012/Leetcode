class Solution {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        sort(arr2.begin(), arr2.end());

        int ans = 0;
        for(int num: arr1){
            int l = num - d;
            int r = num + d;
            // cout<<num<<" "<<l<<" "<<r<<endl;

            auto index1 = lower_bound(arr2.begin(), arr2.end(), l);
            auto index2 = upper_bound(arr2.begin(), arr2.end(), r);

            int count = index1 - arr2.begin() + arr2.end() - index2;
            // cout<<count<<" "<<(index1-arr2.begin())<<" "<<(index2 - arr2.begin())<<endl;
            if(count == arr2.size()){
                ans++;
            }
        }

        return ans;
    }
};