class Solution {
    public long coloredCells(int n) {
        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 5;
        }

        if(n == 3){
            return 13;
        }

        long cells = 13;
        for(int i = 4; i<=n; i++){
            cells += (12 + 4 * (i-4));
        }   

        return cells;
    }
}