class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, currSum1 = 0, currSum2 = 0;
        for(int num: nums){
            currSum1 += num;
            currSum2 += num;

            maxSum = Math.max(maxSum, currSum1);
            minSum = Math.min(minSum, currSum2);
            if(currSum1 < 0){
                currSum1 = 0;
            }

            if(currSum2 > 0){
                currSum2 = 0;
            }
        }

        return Math.max(Math.abs(minSum), maxSum);
    }
}