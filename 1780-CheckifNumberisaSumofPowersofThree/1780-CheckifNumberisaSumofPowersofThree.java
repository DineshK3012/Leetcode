class Solution {
    private boolean helper(int n, int p){
        if(n == 0){
            return true;
        }

        if((int)Math.pow(3, p) > n){
            return false;
        }

        return helper(n, p+1) || helper(n - (int)Math.pow(3, p), p+1);
    }

    public boolean checkPowersOfThree(int n) {
        return helper(n, 0);
    }
}