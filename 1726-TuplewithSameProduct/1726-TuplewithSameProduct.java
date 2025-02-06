class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                int p = nums[i] * nums[j];

                count += (map.getOrDefault(p, 0) * 8);
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
        }

        return count;
    }
}