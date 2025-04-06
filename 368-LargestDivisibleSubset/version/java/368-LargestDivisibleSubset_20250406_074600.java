// Last updated: 4/6/2025, 7:46:00 AM
// DP Tabulation Solution - Longest Increasing Subsequence Pattern
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int parent[] = new int[n];

        int max = 1, maxIndex = 0;
        for(int i = 1; i<n; i++){    
            parent[i] = i;

            for(int prev = i-1; prev>=0; prev--){
                if(nums[i] % nums[prev] == 0 && (1 + dp[prev]) > dp[i]){
                    dp[i] = 1 + dp[prev];
                    parent[i] = prev;
                }
            }

            if(dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        
        List<Integer> output = new ArrayList<>();
        //tracing back the LDS
        while(maxIndex != parent[maxIndex]){
            output.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        output.add(nums[maxIndex]);
        Collections.reverse(output);

        return output;
    }
}