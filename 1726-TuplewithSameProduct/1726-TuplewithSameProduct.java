class Solution {
    public int tupleSameProduct(int[] nums) {
        // Arrays.sort(nums);

        HashMap<Long, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                long p = nums[i] * nums[j];

                if(map.containsKey(p)){
                    count += (map.get(p) * 8);
                }

                map.put(p, map.getOrDefault(p, 0) + 1);
            }
        }

        return count;
    }
}