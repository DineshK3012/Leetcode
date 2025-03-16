class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, max = Integer.MIN_VALUE;
        for(int num: nums){
            if(num > 0 && !set.contains(num)){
                sum += num;
                set.add(num);
            }

            max = Math.max(max, num);
        }

        if(sum == 0){
            return max;
        }

        return sum;
    }
}