class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int ans = 0;
        for(int i = 0; i<n; i++){
            boolean unplaced = true;
            for(int j = 0; j<n; j++){
                if(baskets[j] >= fruits[i]){
                    baskets[j] = 0;
                    unplaced = false;
                    break;
                }
            }

            if(unplaced){
                ans++;
            }
        }

        return ans;
    }
}