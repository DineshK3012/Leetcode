class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int p1 = 1, p2 = 2;// ways to climb only 1 or 2 stair 
        for(int i = 3; i<=n; i++){
            int next = p1 + p2;
            p1 = p2;
            p2 = next;
        }

        return p2;
    }
}