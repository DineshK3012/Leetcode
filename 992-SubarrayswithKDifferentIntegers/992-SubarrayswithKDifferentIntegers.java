class Solution {
    private int countAtLeast(int nums[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0, j = 0;
        while(j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(map.size() >= k){
                ans += (nums.length - j);
                int f = map.get(nums[i]);
                if(f == 1){
                    map.remove(nums[i]);
                }else{
                    map.put(nums[i], f - 1);
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