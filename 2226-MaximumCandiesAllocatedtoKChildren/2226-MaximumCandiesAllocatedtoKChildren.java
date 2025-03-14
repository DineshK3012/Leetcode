class Solution {
    private boolean possible(int[] candies, long k, int m){
        long count = 0;
        for(int j = 0; j<candies.length; j++){
            count += (candies[j] / m);
            if(count >= k){
                return true;
            }
        }

        return count >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int candy: candies){
            sum += candy;
        }

        if(sum < k){
            return 0;
        }

        int l = 1, r = (int)(sum/k);
        int ans = 0;
        while(l <= r){
            int mid = (l + r)/2;

            if(possible(candies, k, mid)){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return ans;
    }
}