class Solution {
    private int countAtLeast(int nums[], int k){
        int freq[] = new int[nums.length + 1];
        int ans = 0;
        int i = 0, j = 0, distinct = 0;
        while(j < nums.length){
            if(freq[nums[j]] == 0){
                distinct++;
            }
            freq[nums[j]]++;

            while(distinct >= k){
                ans += (nums.length - j);
                freq[nums[i]]--;

                if(freq[nums[i]] == 0){
                    distinct--;
                }
                i++;
            }
            j++;
        }

        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtLeast(nums, k) - countAtLeast(nums, k+1);
    }
}