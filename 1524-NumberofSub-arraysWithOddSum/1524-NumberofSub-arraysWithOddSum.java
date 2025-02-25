class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000_000_007;
        int runningOdd = 0;
        int runningEven = 0;
        int res = 0;

        for (int num : arr) {
            if (num % 2 == 1) {
                int tmp = runningOdd;
                runningOdd = runningEven + 1;
                runningEven = tmp; 
            } else {
                runningEven += 1;
            }   
            res += runningOdd;
            res %= MOD;
        }
        return res;
    }
}